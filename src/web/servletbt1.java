package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletbt1")
public class servletbt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void BT1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String url = "";  
		String quantity = request.getParameter("number");
		if(quantity.equals(""))
		{
			url="/errorbt1.jsp";
			RequestDispatcher dispatcherObject= getServletContext().getRequestDispatcher(url);
			dispatcherObject.forward(request, response);
			
		}
		else
		{
			url = "/noerrorbt1.jsp";
			RequestDispatcher dispatcherObject= getServletContext().getRequestDispatcher(url);
			dispatcherObject.forward(request, response);
		}
	}
    public servletbt1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BT1( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
