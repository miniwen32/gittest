package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberFilter implements Filter {

	private FilterConfig config;

	/****** 開始 ******/
	public void init(FilterConfig config) {
		this.config = config;
	}

	/****** 工作 ******/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object account = session.getAttribute("account");
		
		if (account == null) {
System.out.println("--------未成功過filter------------");
			session.setAttribute("location", req.getRequestURI()); // 設路徑為req.自己
			res.sendRedirect(req.getContextPath() + "/front-end/member/mem_login.jsp");
		} else {
System.out.println("--------成功過filter------------");
			chain.doFilter(request, response);
		}

	}

	/****** 結束 ******/
	public void destory() {
		config = null;
	}

}
