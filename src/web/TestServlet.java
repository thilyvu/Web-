package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
			String url = "";  
			String FirstName = request.getParameter("Firstname");
			String email = request.getParameter("Email");
			String LastName = request.getParameter("Lastname");
			
			
			if (FirstName.equals("") || email.equals("") || LastName.equals("")) {
			url = "/error.jsp";
			RequestDispatcher dispatcherObject= getServletContext().getRequestDispatcher(url);
			dispatcherObject.forward(request, response);
			
			}
			else {
			url = "/noerror.jsp";
			RequestDispatcher dispatcherObject= getServletContext().getRequestDispatcher(url);
			dispatcherObject.forward(request, response);
			}
			} 

    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
