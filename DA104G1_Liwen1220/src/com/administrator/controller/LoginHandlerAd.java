package com.administrator.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.administrator.model.AdministratorService;
import com.administrator.model.AdministratorVO;

public class LoginHandlerAd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);

		HttpSession session = req.getSession();
		AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");

		if (adVO != null) {
			session.removeAttribute("adVO");
			session.removeAttribute("nowInAd_name");
			res.sendRedirect(req.getRequestURI());
			return;
		}
		/****************** �U�ؿ��~���� ************************/
		try {
			String account = req.getParameter("account");
			AdministratorService ckadSvc = new AdministratorService();
System.out.println(account);
			if (account.trim().length() == 0) {
				errorMsgs.add("�п�J�b��");
			} else if (!ckadSvc.isAdExist(account)) {
				errorMsgs.add("�d�L���b��");
			}

			String password = req.getParameter("password");
			if (password.trim().length() == 0) {
				errorMsgs.add("�п�J�K�X");
			}
System.out.println(password);
			if (!allowUser(account,password)) {
				errorMsgs.add("�K�X���~");
			}

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("account", account);
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/administrator/administrator_login.jsp");
				fail.forward(req, res);
				return;
			}

			/****************** �n�J���\ ************************/
			AdministratorService adSvc = new AdministratorService();
			AdministratorVO adVOgood = adSvc.loginAdministrator(account);
			String nowInAd_name = adVOgood.getAd_name();

			session.setAttribute("adVO", adVOgood);
			session.setAttribute("account", account);
			session.setAttribute("nowInAd_name", nowInAd_name);

			/******** �qfilter�o��쥻���| **********/
//			String location = (String) session.getAttribute("location");
//			if (location != null) {
//				session.removeAttribute("location");
//				res.sendRedirect(location);
//
//				return;
//			} else {
				RequestDispatcher success = req.getRequestDispatcher("/back-end/manage.jsp");
				success.forward(req, res);

//			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher fail = req.getRequestDispatcher("/back-end/administrator/administrator_login.jsp");
			fail.forward(req, res);
		}

	}

	public boolean allowUser(String account, String password) {

		AdministratorService adSvc = new AdministratorService();
		AdministratorVO adVO = adSvc.loginAdministrator(account);
		String ad_password = adVO.getAd_password();
		if (password.equals(ad_password)) {
			return true;
		} else {
			return false;
		}

	}

}

/********************filter***************************/
//<filter>
// <filter-name>AdministratorFilter</filter-name>
//<filter-class>filters.AdministratorFilter</filter-class>
//</filter>
//<filter-mapping>
//<filter-name>AdministratorFilter</filter-name>
//<url-pattern>/back-end/protected/*</url-pattern>
//<dispatcher>REQUEST</dispatcher>
//<dispatcher>FORWARD</dispatcher>
//<dispatcher>INCLUDE</dispatcher>
//<dispatcher>ERROR</dispatcher>
//<dispatcher>ASYNC</dispatcher>
//</filter-mapping>  
