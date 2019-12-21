package com.member.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.member.model.MemberService;
import com.member.model.MemberVO;

import myUtil.Upload;
import myUtil.ValueToWord;

@MultipartConfig
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		/******************** Ajax動態比對 insert & update ************************/
		PrintWriter out = res.getWriter();

		String account = req.getParameter("account");

		if ("ckaccount".equals(action)) {

			if (account.trim().length() > 3 && account.trim().length() < 10) {
				MemberService memSvc = new MemberService();
				MemberVO memVO = memSvc.loginMember(account);
				if (memVO == null) {
					out.print("<font style='color:green;font-size:small;font-weight:Bold'>此帳號可以使用喔!</font>");
				} else {
					out.print("<font style='color:red;font-size:small;font-weight:Bold'>此帳號已經有人使用了</font>");
				}
			} else {
				out.print("<font style='color:red;font-size:small;font-weight:Bold'>長度必須在4到10之間!</font>");
			}

		}

		/************************ 新增完從資料庫撈mem_no ************************/
		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				HttpSession session = req.getSession();
				MemberVO notrealmemberVO = (MemberVO) session.getAttribute("memberVO");
				String notrealmem_no = notrealmemberVO.getMem_no();

				if (notrealmem_no == null) {

					String mem_account = notrealmemberVO.getMem_account();
					MemberService memSvc = new MemberService();
					MemberVO memberVO = memSvc.loginMember(mem_account);
					String mem_no = memberVO.getMem_no();
					req.setAttribute("mem_no", mem_no);

					/* 成功送出 */
					String mem_status = memberVO.getMem_status();
					memberVO.setMem_status(ValueToWord.turnMemberStatus(mem_status));

					session.setAttribute("memberVO", memberVO);
					RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/mem_login.jsp");
					successView.forward(req, res);
					return;
				}

			} catch (Exception e) {
				errorMsgs.add("無法取得資料耶" + e.getMessage());
				RequestDispatcher failView = req.getRequestDispatcher("/front-end/member/mem_login.jsp");
				failView.forward(req, res);
			}
		}

		/************************ 取得修改資料 ************************/
		if ("get_One_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				String mem_no = req.getParameter("mem_no");

				MemberService memSvc = new MemberService();
				MemberVO memberVO = memSvc.getOneMember(mem_no);
				HttpSession session = req.getSession();
				session.setAttribute("memberVO", memberVO);

				RequestDispatcher successView = req
						.getRequestDispatcher("/front-end/protected/member/update_member_input.jsp");
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("請重新登入!");
				RequestDispatcher faileView = req.getRequestDispatcher("/front-end/member/mem_login.jsp");
				faileView.forward(req, res);
			}

		}

		/************************ 修改 *****************************/

		if (("update").equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String mem_no = req.getParameter("mem_no");
				String ckpassword = "^[A-Za-z0-9]{4,8}$"; // 修改密碼
				String ckname = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,15}$"; // 中文
				String cknumber = "^09[0-9]{8,10}$"; // 電話數字

				/* 檢查密碼 */
				String ck_password =req.getParameter("ck_password");
				String mem_password = req.getParameter("mem_password");
				if (mem_password == null || mem_password.trim().length() == 0) {
					errorMsgs.add("密碼不能留白");
				} else if (!mem_password.trim().matches(ckpassword)) {
					errorMsgs.add("密碼只能是英文、數字,且長度必須在4到10之間!!");
				} else if (!ck_password.equals(mem_password)) {
					errorMsgs.add("密碼不一致");
				}

				/* 檢查姓名 */
				String mem_name = req.getParameter("mem_name");
				if (mem_name == null || mem_name.trim().length() == 0) {
					errorMsgs.add("姓名不得為空");
				} else if (!mem_name.matches(ckname)) {
					errorMsgs.add("姓名只能是中、英文字母且最少2個字，中文最多5個字,英文不超過20個字母");
				}

				/* 檢查生日 */
				java.sql.Date birth = null;
				try {
					birth = java.sql.Date.valueOf(req.getParameter("birth"));
				} catch (IllegalArgumentException e) {
					birth = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入生日!");
				}
				/* 檢查電話 */
				String mem_mobi = req.getParameter("mem_mobi");
				if (mem_mobi == null || mem_mobi.trim().length() == 0) {
					errorMsgs.add("手機不能留白");
				} else if (!mem_mobi.trim().matches(cknumber)) {
					errorMsgs.add("手機只能是數字且長度不超過10");
				}

				/* 檢查信箱 */
				String mem_email = req.getParameter("mem_email");
				if (mem_email == null || mem_email.trim().length() == 0) {
					errorMsgs.add("信箱不得為空");
				}

				/* 檢查地址 */
				String addr = req.getParameter("mem_addr");
				String mem_addr;
				StringBuilder city;
				StringBuilder distric;
				StringBuilder road;

				if (addr == null || addr.trim().length() == 0) {
					errorMsgs.add("地址不得空白");
				}

				try {
					city = new StringBuilder(req.getParameter("city"));
					distric = new StringBuilder(req.getParameter("district"));
					road = new StringBuilder(addr);
					mem_addr = city.append(distric).append(road).toString();
				} catch (NullPointerException nu) {
					mem_addr = addr;
				}

				/* 照片 */
				byte[] mem_pic = null;
				Part part = req.getPart("mem_pic");
				// 從header判斷傳來的資料
				String type = part.getContentType().substring(0, 5);
				if (type.equals("image")) {
					mem_pic = Upload.toPic(part);
				} else {
					MemberService memSvc = new MemberService();
					mem_pic = memSvc.getOneMember(mem_no).getMem_pic();
				}

				/* 抓住無須判別的值 */
				String gender = req.getParameter("gender");
				String mem_account = req.getParameter("mem_account");
				Integer point_count = new Integer(req.getParameter("point_count"));
				Integer mre_count = new Integer(req.getParameter("mre_count"));

				/* 從舊資料取不容修改的值 */
				MemberService memSvc = new MemberService();
				MemberVO memVO = memSvc.getOneMember(mem_no);
				String mem_status = memVO.getMem_status();
				String mem_info = memVO.getMem_info();
				byte[] mem_pho = memSvc.getOneMember(mem_no).getMem_pho();
				String mem_gender = memVO.getGender();
				/* 判斷性別有無更改 */

				if (gender.equals(mem_gender)) {
					gender = mem_gender;
				}

				/* 裝進VO 準備新增 */
				MemberVO memberVO = new MemberVO();

				memberVO.setMem_no(mem_no);
				memberVO.setMem_account(mem_account);
				memberVO.setMem_password(mem_password);
				memberVO.setMem_name(mem_name);
				memberVO.setMem_addr(mem_addr);
				memberVO.setMem_mobi(mem_mobi);
				memberVO.setMem_email(mem_email);
				memberVO.setPoint_count(point_count);
				memberVO.setMre_count(mre_count);
				memberVO.setGender(gender);
				memberVO.setMem_status(mem_status);
				memberVO.setBirth(birth);
				memberVO.setMem_pic(mem_pic);
				memberVO.setMem_pho(mem_pho);
				memberVO.setMem_info(mem_info);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberVO", memberVO);
					RequestDispatcher failView = req
							.getRequestDispatcher("/front-end/protected/member/update_member_input.jsp");
					failView.forward(req, res);
					return;
				}

				/************ 確認更新 ************/
				MemberService surememSvc = new MemberService();
				memberVO = surememSvc.updateMember(mem_no, mem_account, mem_password, mem_name, mem_addr, mem_mobi,
						mem_email, point_count, mre_count, mem_status, birth, gender, mem_pic, mem_pho, mem_info);

				memberVO = surememSvc.getOneMember(mem_no);
				memberVO.setMem_status(ValueToWord.turnMemberStatus(mem_status));
				HttpSession session = req.getSession();
				session.setAttribute("memberVO", memberVO);

				RequestDispatcher successView = req.getRequestDispatcher("/front-end/protected/member/mem_detail.jsp");
				successView.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add(e.getMessage());
				RequestDispatcher failView = req
						.getRequestDispatcher("/front-end/protected/member/update_member_input.jsp");
				failView.forward(req, res);

			}

		}

		/************************ 新增 ************************/
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String ckaccount = "^[A-Za-z0-9]{4,8}$"; // 帳號密碼
			String ckname = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,15}$"; // 中文
			String cknumber = "^09[0-9]{8}$"; // 電話數字

			try {
				/* 檢查帳號 */
				String mem_account = req.getParameter("mem_account");
				MemberService ckmemSvc = new MemberService();

				if (mem_account == null || mem_account.trim().length() == 0) {
					errorMsgs.add("帳號不能留白");
				} else if (!mem_account.matches(ckaccount)) {
					errorMsgs.add("帳號只能是英文、數字,且長度必須在4到8之間!");
				} else if (ckmemSvc.isMemExist(mem_account)) {
					errorMsgs.add("此帳號有人用嘍!");
				}

				/* 檢查密碼 */
				String ck_password =req.getParameter("ck_password");
				String mem_password = req.getParameter("mem_password");
				if (mem_password == null || mem_password.trim().length() == 0) {
					errorMsgs.add("密碼不能留白");
				} else if (!mem_password.trim().matches(ckaccount)) {
					errorMsgs.add("密碼只能是英文、數字,且長度必須在4到10之間!!");
				}else if (!ck_password.equals(mem_password)) {
					errorMsgs.add("密碼不一致");
				}
				/* 抓住性別 */

				String gender = req.getParameter("gender");

				/* 檢查姓名 */
				String mem_name = req.getParameter("mem_name");
				if (mem_name == null || mem_name.trim().length() == 0) {
					errorMsgs.add("姓名不得為空");
				} else if (!mem_name.matches(ckname)) {
					errorMsgs.add("姓名只能是中、英文字母且最少2個字，中文最多5個字,英文不超過20個字母");
				}

				/* 檢查電話 */
				String mem_mobi = req.getParameter("mem_mobi");
				if (mem_mobi == null || mem_mobi.trim().length() == 0) {
					errorMsgs.add("手機不能留白");
				} else if (!mem_mobi.matches(cknumber)) {
					errorMsgs.add("手機只能是數字且長度不超過10");
				}
				/* 檢查生日 */
				java.sql.Date birth = null;
				try {
					birth = java.sql.Date.valueOf(req.getParameter("birth"));
				} catch (IllegalArgumentException e) {
					birth = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入生日!");
				}

				/* 檢查信箱 */
				String mem_email = req.getParameter("mem_email");
				if (mem_email == null || mem_email.trim().length() == 0) {
					errorMsgs.add("信箱不得為空");
				}

				/* 檢查地址 */
				String addr = req.getParameter("mem_addr");
				String mem_addr;
				StringBuilder city;
				StringBuilder distric;
				StringBuilder road;

				if (addr == null || addr.trim().length() == 0) {
					errorMsgs.add("地址不得空白");
				}

				try {
					city = new StringBuilder(req.getParameter("city"));
					distric = new StringBuilder(req.getParameter("district"));
					road = new StringBuilder(addr);
					mem_addr = city.append(distric).append(road).toString();
				} catch (NullPointerException nu) {
					mem_addr = addr;
				}

				/* 照片 */
				Part part = req.getPart("mem_pic");
				String type = part.getContentType().substring(0, 5);
				if (!type.equals("image")) {
					errorMsgs.add("請上傳大頭照");
				}
				byte[] mem_pic = Upload.toPic(part);

				/* 把資料裝進VO */
				MemberVO memberVO = new MemberVO();
				Integer point_count = 0;
				Integer mre_count = 0;
				String mem_status = "0";
				byte[] mem_pho = null;
				String mem_info = "";

				memberVO.setMem_account(mem_account);
				memberVO.setMem_password(mem_password);
				memberVO.setMem_name(mem_name);
				memberVO.setMem_addr(mem_addr);
				memberVO.setMem_mobi(mem_mobi);
				memberVO.setMem_email(mem_email);
				memberVO.setPoint_count(point_count);
				memberVO.setMre_count(mre_count);
				memberVO.setMem_status(mem_status);
				memberVO.setBirth(birth);
				memberVO.setGender(gender);
				memberVO.setMem_pic(mem_pic);
				memberVO.setMem_pho(mem_pho);
				memberVO.setMem_info(mem_info);

				/* 含有輸入格式錯誤的empVO物件,也存入req */
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberVO", memberVO);
					RequestDispatcher failView = req.getRequestDispatcher("/front-end/member/addMember.jsp");
					failView.forward(req, res);
					return;
				}

				/* 新增資料瞜 */
				MemberService memSvc = new MemberService();
				memberVO = memSvc.addMember(mem_account, mem_password, mem_name, mem_addr, mem_mobi, mem_email,
						point_count, mre_count, mem_status, birth, gender, mem_pic, mem_pho, mem_info);

				/* 成功送出,轉交 */
				RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/mem_login.jsp");
				successView.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add(e.getMessage());
				RequestDispatcher failView = req.getRequestDispatcher("/front-end/member/addMember.jsp");
				failView.forward(req, res);
			}

		}

	}
}
