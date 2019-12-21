package com.member.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.member.model.MemberService;

public class MemberPicShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberPicShow() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		res.setContentType("image/gif");
		ServletOutputStream out;
		try {
			// 從參數判斷是哪個會員
			String mem_no = req.getParameter("mem_no").trim();

			MemberService memSvc = new MemberService();
			byte[] mem_pic = memSvc.getOneMember(mem_no).getMem_pic();
			out = res.getOutputStream();
			if (mem_pic != null) {
				out.write(mem_pic);
			} else {
				InputStream in = getServletContext().getResourceAsStream("/images/null2.jpg");
				byte[] b = new byte[in.available()];
				in.read(b);
				out.write(b);
				in.close();
			}

		} catch (NullPointerException ne) {
			try {
				out = res.getOutputStream();
				InputStream in = getServletContext().getResourceAsStream("/images/no.png");
				byte[] b = new byte[in.available()];
				System.out.println(b);
				System.out.println("--------------------");
				in.read(b);
				out.write(b);
				in.close();

			} catch (IOException e) {
				System.out.println("查無圖片的錯誤");
				e.getMessage();
			}

		} catch (IOException ie) {
			System.out.println("大try的錯");
			ie.getMessage();
		}
	}
}
