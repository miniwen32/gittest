package com.administrator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.administrator.model.AdministratorService;
import com.administrator.model.AdministratorVO;
import com.member.model.MemberService;
import com.member.model.MemberVO;

import myUtil.RandomCode;
import myUtil.ValueToWord;

public class AdministratorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		/******************** Ajax動態比對 insert & update ************************/
		PrintWriter out = res.getWriter();
		String account = req.getParameter("account");

		if ("ckaccount".equals(action)) {
			if(account.trim().length() > 3 && account.trim().length() < 10 ) {		
			AdministratorService adSvc = new AdministratorService();
			AdministratorVO adVO = adSvc.loginAdministrator(account);
					if (adVO == null) {
						out.print("<font style='color:green;font-size:small;font-weight:Bold'>此帳號可以使用喔!</font>");
					} else {
						out.print("<font style='color:red;font-size:small;font-weight:Bold'>此帳號已經有人使用了</font>");
					}
			}else {
				out.print("<font style='color:red;font-size:small;font-weight:Bold'>長度必須在4到10之間!</font>");
			}

		}
		
		/******************** 查詢 ************************/

		if ("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
System.out.println("------進查詢-----");
			try {			
//				HttpSession session = req.getSession();	
				/** 空值判斷 **/
				String ad_no = req.getParameter("ad_no");
				if (ad_no == null || ad_no.trim().length() == 0) {
					errorMsgs.add("請輸入員工編號");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/administrator/ad_select_page.jsp");
					fail.forward(req, res);
				}

				/** 資料查詢 **/
				AdministratorService adSrv = new AdministratorService();
				AdministratorVO adVOforOne = adSrv.getOneAndministrator(ad_no);

				if (adVOforOne == null) {
					errorMsgs.add("查無此會員!");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/administrator/ad_select_page.jsp");
					fail.forward(req, res);
				}

				/** 成功送出 **/
				// 從0轉成中文
				String ad_status = adVOforOne.getAd_status();
				adVOforOne.setAd_status(ValueToWord.turnAdministrator(ad_status));			
				req.setAttribute("adVOforOne", adVOforOne);
				RequestDispatcher success = req
						.getRequestDispatcher("/back-end/protected/administrator/listOneAdministrator.jsp");
				success.forward(req, res);

				/** 其他錯誤發生 **/
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("大try發生,無法取得資料" + e.getMessage());
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/administrator/ad_select_page.jsp");
				fail.forward(req, res);
			}

		}

		/******************** 新增 ************************/
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				String ad_account = req.getParameter("ad_account");
				String ckaccount = "^[A-Za-z0-9]{4,8}$"; // 帳號密碼
				String ckname = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,15}$"; // 中文
				String cknumber = "^[0-9]{10}$"; // 電話數字

				;
				
				/* 判斷帳號 */
				AdministratorService ckadSvc = new AdministratorService();
				if (ad_account == null || ad_account.trim().length() == 0) {
					errorMsgs.add("帳號不能留白");
				} else if (!ad_account.matches(ckaccount)) {
					errorMsgs.add("帳號只能是英文、數字,且長度必須在4到8之間!");
				}else if(ckadSvc.isAdExist(ad_account)){
					errorMsgs.add("此帳號已被使用!");
				}

				/* 檢查姓名 */
				String ad_name = req.getParameter("ad_name");

				if (ad_name == null || ad_name.trim().length() == 0) {
					errorMsgs.add("姓名不得為空");
				} else if (!ad_name.matches(ckname)) {
					errorMsgs.add("姓名只能是中、英文字母且最少2個字，中文最多5個字,英文不超過20個字母");
				}

				/* 檢查手機 */
				String ad_mobi = req.getParameter("ad_mobi");
				if (ad_mobi == null || ad_mobi.trim().length() == 0) {
					errorMsgs.add("手機不能留白");
				} else if (!ad_mobi.matches(cknumber)) {
					errorMsgs.add("手機只能是數字且長度不超過10");
				}

				/************ 地址 **********************/
				String addr = req.getParameter("ad_addr");
				StringBuilder city;
				StringBuilder district;
				StringBuilder road;
				String ad_addr;
				
				if (addr == null || addr.trim().length() == 0) {
					errorMsgs.add("地址不得空白");
				}

				try {
				city = new StringBuilder(req.getParameter("city"));
				district = new StringBuilder(req.getParameter("district"));
				road = new StringBuilder(addr);
				ad_addr = city.append(district).append(road).toString();
				}catch(NullPointerException ne) {
					ad_addr = addr;
				}

				/* 信箱 */
				String ad_email = req.getParameter("ad_email");
				if (ad_email == null || ad_email.trim().length() == 0) {
					errorMsgs.add("信箱不得為空");
				}
				/************* 亂數產生密碼 **************/
				RandomCode code = new RandomCode();
				String fake = code.getAuthCode().toString();
				String ad_password = code.getpassword(code.getAuthCode());

				/******************** 亂碼和正碼放一起 ************************/			
				Map passwordmap = new HashMap();
				passwordmap.put(ad_password, fake);

				
				/* 把資料裝進VO */
				AdministratorVO adVOnotyet = new AdministratorVO();
				adVOnotyet.setAd_account(ad_account);
				adVOnotyet.setAd_name(ad_name);
				adVOnotyet.setAd_addr(ad_addr);
				adVOnotyet.setAd_mobi(ad_mobi);
				adVOnotyet.setAd_email(ad_email);

				/* 把錯誤處理完的資料過濾暫存在VO */
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("adVOnotyet", adVOnotyet);
					RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/administrator/addAdministrator.jsp");
					fail.forward(req, res);
					return;
				}

				/* 新增資料進資料庫摟 */
				AdministratorService adSvc = new AdministratorService();
				String ad_status = "1"; // 預設狀態(1-在職)

				req.removeAttribute("adVOnotyet");
				adSvc.addAdministrator(ad_account, ad_password, ad_name, ad_addr, ad_mobi, ad_email, ad_status);
				RequestDispatcher success = req
						.getRequestDispatcher("/back-end/protected/administrator/listAllAdministrator.jsp?whichPage=10");
				success.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("無法新增" + e.getMessage());
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/administrator/addAdministrator.jsp");
				fail.forward(req, res);
			}

		}

		/******************** 修改查詢 ************************/
		if ("get_One_For_Update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs",errorMsgs);
			
			try {
				String ad_no = req.getParameter("ad_no");
				
				AdministratorService adSvc = new AdministratorService();
				AdministratorVO adVO = adSvc.getOneAndministrator(ad_no);
				
				HttpSession session = req.getSession();
				session.setAttribute("adVO",adVO);
				
				RequestDispatcher success = req.getRequestDispatcher("/back-end/protected/administrator/update_administrator.jsp");
				success.forward(req, res);
				
			}catch(Exception e) {
				errorMsgs.add("請重新登入!");
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/administrator/administrator_login.jsp");
				fail.forward(req, res);
			}
			
		}
		 
		 /******************** 修改 ************************/

		if ("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			System.out.println("---------進update-----------");
			try {
				String ad_no = req.getParameter("ad_no");
				String cknumber = "^09[0-9]{8}$"; // 電話數字

				String ad_account = req.getParameter("ad_account");
				
				String ad_name = req.getParameter("ad_name");
				if (ad_name == null || ad_name.trim().length() == 0) {
					errorMsgs.add("姓名不得為空");
				} else if (ad_name.trim().length() >12) {
					errorMsgs.add("姓名只能是中、英文字母且最少2個字，中文最多5個字,英文不超過20個字母");
				}

				String ad_mobi = req.getParameter("ad_mobi");
				if (ad_mobi == null || ad_mobi.trim().length() == 0) {
					errorMsgs.add("手機不能留白");
				} else if (!ad_mobi.matches(cknumber)) {
					errorMsgs.add("手機只能是數字且長度不超過10");
				}

				String ad_email = req.getParameter("ad_email");
				if (ad_email == null || ad_email.trim().length() == 0) {
					errorMsgs.add("信箱不得為空");
				}
				
				/**地址**/
				String addr = req.getParameter("ad_addr");
				StringBuilder city;
				StringBuilder district;
				StringBuilder road;
				String ad_addr;
				if (addr == null || addr.trim().length() == 0) {
					errorMsgs.add("地址不得空白");
				}

				try {
				city = new StringBuilder(req.getParameter("city"));
				district = new StringBuilder(req.getParameter("district"));
				road = new StringBuilder(addr);
				ad_addr = city.append(district).append(road).toString();
				}catch(NullPointerException ne) {
					ad_addr = addr;
				}

				/******** 狀態 *******/
				String ad_status = req.getParameter("ad_status");

				/********* 把資料塞進VO **********/

				AdministratorService adScv = new AdministratorService();
				AdministratorVO adVO = adScv.getOneAndministrator(ad_no);
				String ad_password = adVO.getAd_password();
				java.sql.Date ad_wdate =  adVO.getAd_wdate();
				adVO.setAd_no(ad_no);
				adVO.setAd_account(ad_account);
				adVO.setAd_password(ad_password);
				adVO.setAd_name(ad_name);
				adVO.setAd_addr(ad_addr);
				adVO.setAd_mobi(ad_mobi);
				adVO.setAd_email(ad_email);
				adVO.setAd_status(ad_status);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("adVO", adVO);
					RequestDispatcher fail = req
							.getRequestDispatcher("/back-end/protected/administrator/update_administrator.jsp");
					fail.forward(req, res);
					return;
				}
				/********* 確認更新! **********/
				AdministratorService adSvc = new AdministratorService();
				adVO = adSvc.updateAdministrator(ad_account, ad_password, ad_name, ad_addr, ad_mobi, ad_email,
						ad_status, ad_no);
				
				adVO.setAd_status(ValueToWord.turnAdministrator(ad_status));
				adVO.setAd_wdate(ad_wdate);
				req.setAttribute("adVOupdate", adVO);
				
				
				RequestDispatcher success = req
						.getRequestDispatcher("/back-end/protected/administrator/listOneAdministrator.jsp");
				success.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("更新失敗" + e.getMessage());
				RequestDispatcher fail = req
						.getRequestDispatcher("/back-end/protected/administrator/update_administrator.jsp");
				fail.forward(req, res);
			}

		}

	}

}
