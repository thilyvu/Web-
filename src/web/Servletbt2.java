	package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servletbt2")
public class Servletbt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void BT2(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String url = "";  
		String NumberOfProduct = request.getParameter("NumberOfProduct");
		String NameofCustomer = request.getParameter("NameofCustomer");
		String Email = request.getParameter("Email");
		
		if(Email.equals("")||NumberOfProduct.equals("")||NameofCustomer.equals("") )
		{
			url="/errorbt2.jsp";
			RequestDispatcher dispatcherObject= getServletContext().getRequestDispatcher(url);
			dispatcherObject.forward(request, response);
			
		}
		else
		{
			url = "/noerrorbt2.jsp";
			RequestDispatcher dispatcherObject= getServletContext().getRequestDispatcher(url);
			dispatcherObject.forward(request, response);
		}
	}
    public Servletbt2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BT2( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
