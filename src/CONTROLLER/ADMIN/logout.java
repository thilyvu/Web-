package CONTROLLER.ADMIN;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession session=request.getSession();  
       session.invalidate(); 
       resp.sendRedirect(request.getContextPath()+"/admin/login.jsp");
	}

}
