package CONTROLLER.USER.PAYMENT;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadPayment
 */
@WebServlet("/LoadPayment")
public class LoadPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    		request.getRequestDispatcher("./Payment/Payment.jsp").forward(request, resp);
    		
    	}

}
