package com.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;

public class LoginHandlerMem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		Map<String,String> alert = new HashMap<>();
		req.setAttribute("alert", alert);
		
		HttpSession session = req.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");	

		if (memberVO != null) {
			session.removeAttribute("memberVO");
//			session.removeAttribute("chefVO"); //�����p�vVO
			String URI = (String) session.getAttribute("URI");
			session.removeAttribute("URI");
			res.sendRedirect(URI);
			return;
		}

		/****************** �U�ؿ��~���� ************************/
		try {
			/* �ˬd�b�� */
			String account = req.getParameter("account");			
			MemberService ckmemSvc = new MemberService();
						
			if (account.trim().length() == 0) {
				errorMsgs.add("�п�J�b��");
				
			} else if (!ckmemSvc.isMemExist(account)) {
				errorMsgs.add("�d�L���b��!");
			}

			String password = req.getParameter("password");
			if (password.trim().length() == 0) {
				errorMsgs.add("�п�J�K�X");
			}

			if (!allowUser(account, password)) {
				errorMsgs.add("�K�X���~!");
			}

			/****************** �n�J���ѯd��b�� ************************/
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("account", account);
				RequestDispatcher fail = req.getRequestDispatcher("/front-end/member/mem_login.jsp");
				fail.forward(req, res);
				return;
			}

			/****************** �n�J���\ ************************/
			MemberService memSvc = new MemberService();	
			MemberVO memberVOgood = memSvc.loginMember(account);
			session.setAttribute("memberVO", memberVOgood);
			session.setAttribute("account", account);
			
			/* �ˬd�O�_���p�v */
//			  String mem_no = memberVOgood.getMem_no();
//			   ChefService ckchefSvc = new ChefService();
//			   ChefVO chefVO = ckchefSvc.getOneChef(mem_no);
//			   if (chefVO != null) {
//			    session.setAttribute("chefVO", chefVO);
//			   }
			
			/******** �qfilter�o��쥻���| **********/
			String location = (String) session.getAttribute("location");
			if (location != null) {
				// ���O�@�ɦV
				session.removeAttribute("location");
				res.sendRedirect(location);
				return;
			} else {
				// �����O�@�ɦV
				String URI = (String) session.getAttribute("URI");
				if(URI == null) {
					RequestDispatcher success = req.getRequestDispatcher("/front-end/index.jsp");
					success.forward(req, res);
					return;
				}
				res.sendRedirect(URI);
			}
		} catch (Exception e) {
			RequestDispatcher fail = req.getRequestDispatcher("/front-end/member/mem_login.jsp");
			fail.forward(req, res);

		}
	}

	/****************** �b�K�O�_���T,�^��boolean ************************/
	protected boolean allowUser(String account, String password) {

		MemberService memSvc = new MemberService();
		MemberVO memVO = memSvc.loginMember(account);
		String mem_password = memVO.getMem_password();
		if (password.equals(mem_password)) {
			return true;
		} else {
			return false;
		}
	}

}
