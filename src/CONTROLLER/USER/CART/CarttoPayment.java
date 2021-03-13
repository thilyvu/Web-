package CONTROLLER.USER.CART;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarttoPayment
 */
@WebServlet("/CarttoPayment")
public class CarttoPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   HttpSession session=request.getSession();
	   String jsonCarArray = request.getParameter("giohang");
		try {
				session.setAttribute("json", jsonCarArray);
				
		} catch (Exception e) {
			
		}
		request.getServletContext().getRequestDispatcher("/Payment/Payment.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/LoadPayment");
	}
}
