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

public class AdministratorFilter implements Filter {
private  FilterConfig config;

	public void destroy() {
		config=null;
	}
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
	}
	
	//�u�@
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object account = session.getAttribute("account");
		
		
		if(account == null){
System.out.println("-------�����\�Lfilter------------");
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath()+"/back-end/administrator/administrator_login.jsp");
		}else {
System.out.println("--------���\�Lfilter------------");
			chain.doFilter(request, response);
			
		}
			
	}

}
