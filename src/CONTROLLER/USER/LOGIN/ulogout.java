package CONTROLLER.USER.LOGIN;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ulogout
 */
@WebServlet("/ulogout")
public class ulogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession session=request.getSession();
       session.invalidate();
       resp.setHeader("Cache-Control","no-cache"); 
       resp.setHeader("Cache-Control","no-store");
       resp.setHeader("Pragma","no-cache");
       resp.setDateHeader("Expires", 0); 
       resp.sendRedirect(request.getContextPath()+"/HomePage/home_loggedin.jsp");
	}

}
