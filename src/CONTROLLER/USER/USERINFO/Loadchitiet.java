package CONTROLLER.USER.USERINFO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Cchitietdonhang;
import MODEL.User;

/**
 * Servlet implementation class Loadchitiet
 */
@WebServlet("/Loadchitiet")
public class Loadchitiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session=request.getSession();
	    	
	    	try
	    	{
	    		User u=(User)session.getAttribute("user");
	        	if(u!=null)
	        	{
	    			int iddh=Integer.parseInt(request.getParameter("iddh"));
	    			ArrayList<Object[]> list=Cchitietdonhang.GetAllChitietbyDonhang(iddh, u.getId_user());
	    			request.setAttribute("list", list);
	        	}
    		}
    		catch (Exception e) {
				// TODO: handle exception
			}
    		request.getServletContext().getRequestDispatcher("/UserInfo/Chitietbyid.jsp").forward(request, response);
	}

}
