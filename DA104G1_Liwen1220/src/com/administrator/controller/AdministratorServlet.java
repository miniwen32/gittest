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
		
		/******************** Ajax�ʺA��� insert & update ************************/
		PrintWriter out = res.getWriter();
		String account = req.getParameter("account");

		if ("ckaccount".equals(action)) {
			if(account.trim().length() > 3 && account.trim().length() < 10 ) {		
			AdministratorService adSvc = new AdministratorService();
			AdministratorVO adVO = adSvc.loginAdministrator(account);
					if (adVO == null) {
						out.print("<font style='color:green;font-size:small;font-weight:Bold'>���b���i�H�ϥγ�!</font>");
					} else {
						out.print("<font style='color:red;font-size:small;font-weight:Bold'>���b���w�g���H�ϥΤF</font>");
					}
			}else {
				out.print("<font style='color:red;font-size:small;font-weight:Bold'>���ץ����b4��10����!</font>");
			}

		}
		
		/******************** �d�� ************************/

		if ("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
System.out.println("------�i�d��-----");
			try {			
//				HttpSession session = req.getSession();	
				/** �ŭȧP�_ **/
				String ad_no = req.getParameter("ad_no");
				if (ad_no == null || ad_no.trim().length() == 0) {
					errorMsgs.add("�п�J���u�s��");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/administrator/ad_select_page.jsp");
					fail.forward(req, res);
				}

				/** ��Ƭd�� **/
				AdministratorService adSrv = new AdministratorService();
				AdministratorVO adVOforOne = adSrv.getOneAndministrator(ad_no);

				if (adVOforOne == null) {
					errorMsgs.add("�d�L���|��!");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/administrator/ad_select_page.jsp");
					fail.forward(req, res);
				}

				/** ���\�e�X **/
				// �q0�ন����
				String ad_status = adVOforOne.getAd_status();
				adVOforOne.setAd_status(ValueToWord.turnAdministrator(ad_status));			
				req.setAttribute("adVOforOne", adVOforOne);
				RequestDispatcher success = req
						.getRequestDispatcher("/back-end/protected/administrator/listOneAdministrator.jsp");
				success.forward(req, res);

				/** ��L���~�o�� **/
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("�jtry�o��,�L�k���o���" + e.getMessage());
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/administrator/ad_select_page.jsp");
				fail.forward(req, res);
			}

		}

		/******************** �s�W ************************/
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				String ad_account = req.getParameter("ad_account");
				String ckaccount = "^[A-Za-z0-9]{4,8}$"; // �b���K�X
				String ckname = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,15}$"; // ����
				String cknumber = "^[0-9]{10}$"; // �q�ܼƦr

				;
				
				/* �P�_�b�� */
				AdministratorService ckadSvc = new AdministratorService();
				if (ad_account == null || ad_account.trim().length() == 0) {
					errorMsgs.add("�b������d��");
				} else if (!ad_account.matches(ckaccount)) {
					errorMsgs.add("�b���u��O�^��B�Ʀr,�B���ץ����b4��8����!");
				}else if(ckadSvc.isAdExist(ad_account)){
					errorMsgs.add("���b���w�Q�ϥ�!");
				}

				/* �ˬd�m�W */
				String ad_name = req.getParameter("ad_name");

				if (ad_name == null || ad_name.trim().length() == 0) {
					errorMsgs.add("�m�W���o����");
				} else if (!ad_name.matches(ckname)) {
					errorMsgs.add("�m�W�u��O���B�^��r���B�̤�2�Ӧr�A����̦h5�Ӧr,�^�夣�W�L20�Ӧr��");
				}

				/* �ˬd��� */
				String ad_mobi = req.getParameter("ad_mobi");
				if (ad_mobi == null || ad_mobi.trim().length() == 0) {
					errorMsgs.add("�������d��");
				} else if (!ad_mobi.matches(cknumber)) {
					errorMsgs.add("����u��O�Ʀr�B���פ��W�L10");
				}

				/************ �a�} **********************/
				String addr = req.getParameter("ad_addr");
				StringBuilder city;
				StringBuilder district;
				StringBuilder road;
				String ad_addr;
				
				if (addr == null || addr.trim().length() == 0) {
					errorMsgs.add("�a�}���o�ť�");
				}

				try {
				city = new StringBuilder(req.getParameter("city"));
				district = new StringBuilder(req.getParameter("district"));
				road = new StringBuilder(addr);
				ad_addr = city.append(district).append(road).toString();
				}catch(NullPointerException ne) {
					ad_addr = addr;
				}

				/* �H�c */
				String ad_email = req.getParameter("ad_email");
				if (ad_email == null || ad_email.trim().length() == 0) {
					errorMsgs.add("�H�c���o����");
				}
				/************* �üƲ��ͱK�X **************/
				RandomCode code = new RandomCode();
				String fake = code.getAuthCode().toString();
				String ad_password = code.getpassword(code.getAuthCode());

				/******************** �ýX�M���X��@�_ ************************/			
				Map passwordmap = new HashMap();
				passwordmap.put(ad_password, fake);

				
				/* ���Ƹ˶iVO */
				AdministratorVO adVOnotyet = new AdministratorVO();
				adVOnotyet.setAd_account(ad_account);
				adVOnotyet.setAd_name(ad_name);
				adVOnotyet.setAd_addr(ad_addr);
				adVOnotyet.setAd_mobi(ad_mobi);
				adVOnotyet.setAd_email(ad_email);

				/* ����~�B�z������ƹL�o�Ȧs�bVO */
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("adVOnotyet", adVOnotyet);
					RequestDispatcher fail = req.getRequestDispatcher("/back-end/protected/administrator/addAdministrator.jsp");
					fail.forward(req, res);
					return;
				}

				/* �s�W��ƶi��Ʈw�O */
				AdministratorService adSvc = new AdministratorService();
				String ad_status = "1"; // �w�]���A(1-�b¾)

				req.removeAttribute("adVOnotyet");
				adSvc.addAdministrator(ad_account, ad_password, ad_name, ad_addr, ad_mobi, ad_email, ad_status);
				RequestDispatcher success = req
						.getRequestDispatcher("/back-end/protected/administrator/listAllAdministrator.jsp?whichPage=10");
				success.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("�L�k�s�W" + e.getMessage());
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/administrator/addAdministrator.jsp");
				fail.forward(req, res);
			}

		}

		/******************** �ק�d�� ************************/
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
				errorMsgs.add("�Э��s�n�J!");
				RequestDispatcher fail = req.getRequestDispatcher("/back-end/administrator/administrator_login.jsp");
				fail.forward(req, res);
			}
			
		}
		 
		 /******************** �ק� ************************/

		if ("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			System.out.println("---------�iupdate-----------");
			try {
				String ad_no = req.getParameter("ad_no");
				String cknumber = "^09[0-9]{8}$"; // �q�ܼƦr

				String ad_account = req.getParameter("ad_account");
				
				String ad_name = req.getParameter("ad_name");
				if (ad_name == null || ad_name.trim().length() == 0) {
					errorMsgs.add("�m�W���o����");
				} else if (ad_name.trim().length() >12) {
					errorMsgs.add("�m�W�u��O���B�^��r���B�̤�2�Ӧr�A����̦h5�Ӧr,�^�夣�W�L20�Ӧr��");
				}

				String ad_mobi = req.getParameter("ad_mobi");
				if (ad_mobi == null || ad_mobi.trim().length() == 0) {
					errorMsgs.add("�������d��");
				} else if (!ad_mobi.matches(cknumber)) {
					errorMsgs.add("����u��O�Ʀr�B���פ��W�L10");
				}

				String ad_email = req.getParameter("ad_email");
				if (ad_email == null || ad_email.trim().length() == 0) {
					errorMsgs.add("�H�c���o����");
				}
				
				/**�a�}**/
				String addr = req.getParameter("ad_addr");
				StringBuilder city;
				StringBuilder district;
				StringBuilder road;
				String ad_addr;
				if (addr == null || addr.trim().length() == 0) {
					errorMsgs.add("�a�}���o�ť�");
				}

				try {
				city = new StringBuilder(req.getParameter("city"));
				district = new StringBuilder(req.getParameter("district"));
				road = new StringBuilder(addr);
				ad_addr = city.append(district).append(road).toString();
				}catch(NullPointerException ne) {
					ad_addr = addr;
				}

				/******** ���A *******/
				String ad_status = req.getParameter("ad_status");

				/********* ���ƶ�iVO **********/

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
				/********* �T�{��s! **********/
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
				errorMsgs.add("��s����" + e.getMessage());
				RequestDispatcher fail = req
						.getRequestDispatcher("/back-end/protected/administrator/update_administrator.jsp");
				fail.forward(req, res);
			}

		}

	}

}
