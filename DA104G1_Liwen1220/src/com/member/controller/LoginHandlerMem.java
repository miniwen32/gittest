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
//			session.removeAttribute("chefVO"); //移除廚師VO
			String URI = (String) session.getAttribute("URI");
			session.removeAttribute("URI");
			res.sendRedirect(URI);
			return;
		}

		/****************** 各種錯誤驗證 ************************/
		try {
			/* 檢查帳號 */
			String account = req.getParameter("account");			
			MemberService ckmemSvc = new MemberService();
						
			if (account.trim().length() == 0) {
				errorMsgs.add("請輸入帳號");
				
			} else if (!ckmemSvc.isMemExist(account)) {
				errorMsgs.add("查無此帳號!");
			}

			String password = req.getParameter("password");
			if (password.trim().length() == 0) {
				errorMsgs.add("請輸入密碼");
			}

			if (!allowUser(account, password)) {
				errorMsgs.add("密碼錯誤!");
			}

			/****************** 登入失敗留住帳號 ************************/
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("account", account);
				RequestDispatcher fail = req.getRequestDispatcher("/front-end/member/mem_login.jsp");
				fail.forward(req, res);
				return;
			}

			/****************** 登入成功 ************************/
			MemberService memSvc = new MemberService();	
			MemberVO memberVOgood = memSvc.loginMember(account);
			session.setAttribute("memberVO", memberVOgood);
			session.setAttribute("account", account);
			
			/* 檢查是否為廚師 */
//			  String mem_no = memberVOgood.getMem_no();
//			   ChefService ckchefSvc = new ChefService();
//			   ChefVO chefVO = ckchefSvc.getOneChef(mem_no);
//			   if (chefVO != null) {
//			    session.setAttribute("chefVO", chefVO);
//			   }
			
			/******** 從filter得到原本路徑 **********/
			String location = (String) session.getAttribute("location");
			if (location != null) {
				// 受保護導向
				session.removeAttribute("location");
				res.sendRedirect(location);
				return;
			} else {
				// 未受保護導向
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

	/****************** 帳密是否正確,回傳boolean ************************/
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
