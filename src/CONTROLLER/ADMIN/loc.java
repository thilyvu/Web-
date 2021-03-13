package CONTROLLER.ADMIN;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import MODEL.User;

/**
 * Servlet Filter implementation class loc
 */
@WebFilter(urlPatterns = {"/quanli", "/quanli/*"})
public class loc implements Filter {

    /**
     * Default constructor. 
     */
    public loc() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		 HttpSession session=req.getSession();
		 User u=(User)session.getAttribute("admin");
		 if(u==null || u.getPermission().equals("0"))
			request.getServletContext().getRequestDispatcher("/admin/login.jsp").forward(request, response);
		 else
		// pass the request along the filter chain
			 chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
