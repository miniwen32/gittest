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
			// �q�ѼƧP�_�O���ӷ|��
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
				System.out.println("�d�L�Ϥ������~");
				e.getMessage();
			}

		} catch (IOException ie) {
			System.out.println("�jtry����");
			ie.getMessage();
		}
	}
}
