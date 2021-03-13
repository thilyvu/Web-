package CONTROLLER.USER.LOGIN;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Cuser;
import MODEL.User;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns={"/Login"})
//@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    boolean pat(String mau,String vanban)
   	{
   		Pattern pattern = Pattern.compile(mau);
   	    Matcher matcher = pattern.matcher(vanban);
   	    boolean matches = matcher.matches(); 
   	    return matches;
   	}
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	String url = "/login/login.jsp";
    	try
    	{
	    	//parameter from jsp
	    	String emailError = "";
	    	String passError = "";
	    	String email = request.getParameter("email");
	    	String password = request.getParameter("password");
	    	int loginState = 0;
	    	User u=null;
	    	if (email==null || password==null ) {
	    		url = "/login/login.jsp";
	    		if(email == null) {emailError="Vui lòng nhập email.";}
	    		if(password == null) {passError="Vui lòng nhập mật khẩu.";}
	    		
	    	}
	    	else 
	    	{
	    		u=Cuser.getUserbyid(email, password);
	    		if(u==null) 
	    		{
	    			passError = "Sai mật khẩu.";
	    			emailError = "Email không tồn tại.";
	    		}
	    		else
	    		{
	    			System.out.print(u.getKichhoat());
	    			if(u.getKichhoat().equals("1"))
		    		{
			    		url = "/HomePage/home_loggedin.jsp"; loginState = 1;
			    		session.setAttribute("user", u);
		    		}
	    		}
	    	}
	    	request.setAttribute("emailError",emailError);
	    	request.setAttribute("passError",passError);
	    	request.setAttribute("loginState",loginState);
    		}
    	catch (Exception e) {
			// TODO: handle exception
		} 
    	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
    	dispatcher.forward(request, response);
    }
  

}
