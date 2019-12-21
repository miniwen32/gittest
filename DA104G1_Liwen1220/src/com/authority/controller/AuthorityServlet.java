package com.authority.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.authority.model.AuthorityService;
import com.authority.model.AuthorityVO;

public class AuthorityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if("getOne_For_Display".equals(action)) {
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
			try{
				String auth_no = req.getParameter("auth_no");
				if(auth_no == null|| auth_no.trim().length() == 0) {
					errorMsgs.add("�п�J�s��!!");
				}
				
				if(!errorMsgs.isEmpty()) {
					RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/authority/auth_select_page.jsp");
				fail.forward(req, res);
				}
				
				/**********�d��***********/
				AuthorityService authSvc = new AuthorityService();
				AuthorityVO authVO = authSvc.getOneAuthority(auth_no);
				
				if(authVO == null) {
					errorMsgs.add("�d�L�|��");
				}
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/authority/auth_select_page.jsp");
					fail.forward(req, res);
				}
				
				req.setAttribute("authVO", authVO);
				RequestDispatcher success = req.getRequestDispatcher("/back-end/protected/authority/listOneAuthority.jsp");
				success.forward(req, res);
				
			}catch(Exception e){
			e.printStackTrace();
			errorMsgs.add("�d�ߥ���"+e.getMessage());
			RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/authority/auth_select_page.jsp");
				fail.forward(req, res);
			}
	
		}
		
		if("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String ckno = "^[A-Za-z0-9]{1,4}$";
			String ckname = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,100}$"; // ����
			
			try {
				String auth_no = req.getParameter("auth_no");
				if(auth_no == null|| auth_no.trim().length() == 0) {
					errorMsgs.add("�s������d��");
				}else if(!auth_no.matches(ckno)) {
					errorMsgs.add("�s�����פ��o�W�L4");
				}
				
				String auth_name = req.getParameter("auth_name");
				if (auth_name == null || auth_name.trim().length() == 0) {
					errorMsgs.add("�W�٤��o����");
				} else if (!auth_name.matches(ckname)) {
					errorMsgs.add("�W�٥u��O���B�^��r���B�̤�2�Ӧr�A����̦h5�Ӧr,�^�夣�W�L20�Ӧr��");
				}
				
				String auth_note = req.getParameter("auth_note");
				if (auth_note == null || auth_note.trim().length() == 0) {
					errorMsgs.add("�ж�g²�z");
				}
				
				AuthorityVO authVO = new AuthorityVO();
				authVO.setAuth_no(auth_no);
				authVO.setAuth_name(auth_name);
				authVO.setAuth_note(auth_note);
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("authVO", authVO);
					RequestDispatcher fail = req
							.getRequestDispatcher("/back-end/protected/authority/addAuthority.jsp");
					fail.forward(req, res);
					return;
				}
				
				AuthorityService authSvc = new AuthorityService();
				authVO = authSvc.addAuthority(auth_no, auth_name, auth_note);
				
				RequestDispatcher success = req
						.getRequestDispatcher("/back-end/protected/authority/listAllAuthority.jsp");
				success.forward(req, res);
				
			}catch(Exception e) {
				e.printStackTrace();
				errorMsgs.add("�L�k�s�W" + e.getMessage());
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/authority/addAuthority.jsp");
				fail.forward(req, res);
			}
		}
		
/*--------------------�ק�-----------------------*/
		if("get_One_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {			
				String auth_no = req.getParameter("auth_no");				
				AuthorityService authSvc = new AuthorityService();
				AuthorityVO authVO =authSvc.getOneAuthority(auth_no);
				
				req.setAttribute("authVO",authVO);
				RequestDispatcher success =  req.getRequestDispatcher("/back-end/protected/authority/update_authority_input.jsp");
				success.forward(req, res);
			}catch(Exception e) {
				errorMsgs.add("�d�ߥ���");
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/authority/auth_select_page.jsp");
				fail.forward(req, res);
			}
			
			
		}
		
		
		if("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String ckno = "^[A-Za-z0-9]{1,4}$";
			String ckname = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,100}$"; // ����
			
			try {			
				String auth_no = req.getParameter("auth_no");
				
				String auth_name = req.getParameter("auth_name");
				if (auth_name == null || auth_name.trim().length() == 0) {
					errorMsgs.add("�W�٤��o����");
				} else if (!auth_name.matches(ckname)) {
					errorMsgs.add("�W�٥u��O���B�^��r���B�̤�2�Ӧr�A����̦h5�Ӧr,�^�夣�W�L20�Ӧr��");
				}
				
				String auth_note = req.getParameter("auth_note");
				if (auth_note == null || auth_note.trim().length() == 0) {
					errorMsgs.add("�ж�g²�z");
				}
				
				AuthorityVO authVO = new AuthorityVO();
				authVO.setAuth_no(auth_no);
				authVO.setAuth_name(auth_name);
				authVO.setAuth_note(auth_note);
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("authVO", authVO);
					RequestDispatcher fail = req
							.getRequestDispatcher("/back-end/protected/authority/update_authority_input.jsp");
					fail.forward(req, res);
					return;
				}
				
				AuthorityService authSvc = new AuthorityService();
				authVO = authSvc.updateAuthority(auth_name, auth_note,auth_no);
				req.setAttribute("authVO",authVO);
				RequestDispatcher success = req
						.getRequestDispatcher("/back-end/protected/authority/listOneAuthority.jsp");
				success.forward(req, res);
				
			}catch(Exception e) {
				e.printStackTrace();
				errorMsgs.add("�L�k�s�W" + e.getMessage());
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/authority/addAuthority.jsp");
				fail.forward(req, res);
			}
		
		}
	
	}
}
