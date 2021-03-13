package CONTROLLER.USER.USERINFO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MODEL.User;

/**
 * Servlet implementation class Loasuserinfo
 */
@WebServlet("/Loasuserinfo")
public class Loasuserinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	    	HttpSession session=request.getSession();
	    	
	    	try
	    	{
	    		User u=(User)session.getAttribute("user");
	        	if(u!=null)
	        	{
	        		request.setAttribute("name", u.getTenhienthi());
	 		        request.setAttribute("usernamedisplay", u.getTenhienthi());
	 		        request.setAttribute("email", u.getEmail());
	 		        request.setAttribute("phone", u.getSdt());
	 		        request.setAttribute("address", u.getDiachi());
	 		        request.setAttribute("birthday", u.getNgaysinh());
	 		       request.setAttribute("selectImage", u.getAvatar());
	        	}
	    	}
	    	catch (Exception e) {
				// TODO: handle exception
			}
	    	request.getRequestDispatcher("./UserInfo/userInfo.jsp").forward(request, resp);
    }

}
