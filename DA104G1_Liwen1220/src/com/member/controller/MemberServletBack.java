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
public class MemberServletBack extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			
			
			try {
				/* 空值確認 */
				String mem_no = req.getParameter("mem_no");
				if (mem_no == null || (mem_no.trim().length() == 0)) {
					errorMsgs.add("請輸入會員編號!!!!!");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failView = req.getRequestDispatcher("/back-end/protected/member/mem_select_page.jsp");
					failView.forward(req, res);
					return;
				}

				/* 查詢資料 */
				MemberService memSvc = new MemberService();
				MemberVO memberVO = memSvc.getOneMember(mem_no);
				if (memberVO == null) {
					errorMsgs.add("查無此會員");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failView = req.getRequestDispatcher("/back-end/protected/member/mem_select_page.jsp");
					failView.forward(req, res);
				}

				/* 成功送出 */

				String gender = memberVO.getGender();
				memberVO.setGender(ValueToWord.turnGender(gender));

				String mem_status = memberVO.getMem_status();

				memberVO.setMem_status(ValueToWord.turnMemberStatus(mem_status));
				
				req.setAttribute("memberVO", memberVO);
				RequestDispatcher successView = req.getRequestDispatcher("/back-end/protected/member/listOneMember.jsp");
				successView.forward(req, res);

				/* 其他錯誤發生 */
			} catch (Exception e) {
				errorMsgs.add("無法取得資料耶" + e.getMessage());
				RequestDispatcher failView = req.getRequestDispatcher("/back-end/protected/member/mem_select_page.jsp");
				failView.forward(req, res);
			}
		}

		/*--------------------取得修改資料------------------------*/

		if ("get_One_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String mem_no = req.getParameter("mem_no");

				MemberService memSvc = new MemberService();
				MemberVO memberVO = memSvc.getOneMember(mem_no);

				req.setAttribute("memberVO", memberVO);
				RequestDispatcher successView = req.getRequestDispatcher("/back-end/protected/member/update_member_input.jsp");
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("無法取得須修改的資料!" + e.getMessage());
				RequestDispatcher faileView = req.getRequestDispatcher("/back-end/protected/member/mem_select_page.jsp");
				faileView.forward(req, res);
			}

		}

		/*--------------------修改------------------------*/

		if (("update").equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String mem_no = req.getParameter("mem_no");
				String mem_name = req.getParameter("mem_name");
				java.sql.Date birth = java.sql.Date.valueOf(req.getParameter("birth"));
				String mem_mobi = req.getParameter("mem_mobi");
				String mem_email = req.getParameter("mem_email");
				String mem_addr = req.getParameter("mem_addr");
				String mem_password = req.getParameter("mem_password");
				String gender = req.getParameter("gender");
				String mem_account = req.getParameter("mem_account");
				Integer point_count = new Integer(req.getParameter("point_count"));
				Integer mre_count = new Integer(req.getParameter("mre_count"));
				java.sql.Date sign_up_date = java.sql.Date.valueOf(req.getParameter("sign_up_date"));
				
				/*唯一可以被更改的值*/
				String mem_status = req.getParameter("mem_status");
				
				MemberService memSvc = new MemberService();
				MemberVO memVO = memSvc.getOneMember(mem_no);
				String mem_info = memVO.getMem_info();
				byte[] mem_pic = memSvc.getOneMember(mem_no).getMem_pic();
				byte[] mem_pho = memSvc.getOneMember(mem_no).getMem_pho();

				/* 裝進VO 準備更新 */
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
					RequestDispatcher failView = req.getRequestDispatcher("/back-end/protected/member/update_member_input.jsp");
					failView.forward(req, res);
					return;
				}

				/************ 確認更新 ************/
				MemberService surememSvc = new MemberService();
				memberVO = surememSvc.updateMember(mem_no, mem_account, mem_password, mem_name, mem_addr, mem_mobi,
						mem_email, point_count, mre_count, mem_status, birth, gender, mem_pic, mem_pho, mem_info);
				memberVO = surememSvc.getOneMember(mem_no);
				memberVO.setMem_status(ValueToWord.turnMemberStatus(mem_status));
				memberVO.setGender(ValueToWord.turnGender(gender));
				req.setAttribute("memberVO", memberVO);
				RequestDispatcher successView = req.getRequestDispatcher("/back-end/protected/member/listOneMember.jsp");
				successView.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add(e.getMessage());
				RequestDispatcher failView = req.getRequestDispatcher("/back-end/protected/member/update_member_input.jsp");
				failView.forward(req, res);

			}

		}


		if ("delete".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String mem_no = req.getParameter("mem_no");
				MemberService memSvc = new MemberService();
				memSvc.deleteMember(mem_no);

				RequestDispatcher success = req.getRequestDispatcher("/back-end/protected/member/listAllMember.jsp?whichPage=10");
				success.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗" + e.getMessage());
				RequestDispatcher failView = req.getRequestDispatcher("/back-end/protected/member/listAllMember.jsp");
				failView.forward(req, res);
			}
		}

	}
}
