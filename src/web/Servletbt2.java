	package web;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String url = "/BT2.jsp";  
		String NumberOfProduct = request.getParameter("NumberOfProduct");
		String NameofCustomer = request.getParameter("NameofCustomer");
		String Email = request.getParameter("Email");
		// conditions for number
		
		int quantitynumber=0;
		quantitynumber=Integer.parseInt(NumberOfProduct);
		if(quantitynumber>=1)
		{
			request.setAttribute("numberbackup", quantitynumber);
		}
		else {
			request.setAttribute("number", "your input numbers must greater than 0");
		}
		//conditions for name
		request.setAttribute("name",NameofCustomer);
		//condition for email
		Pattern EmailPattern =Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
		Matcher MatcherEmail =EmailPattern.matcher(Email);
		if(!MatcherEmail.matches()) {
			request.setAttribute("email", "Your email is not true format please check it again");
		}
		else
		{
			request.setAttribute("emailBackup", Email);
		}
		
		//////////////////////
		if(request.getAttribute("emailBackup")!=null && request.getAttribute("numberbackup")!=null && request.getAttribute("name")!=null) 
		{	
					url="/noerrorbt2.jsp";
		}
		
		RequestDispatcher dispatcherObject= getServletContext().getRequestDispatcher(url);
		dispatcherObject.forward(request, response);
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
