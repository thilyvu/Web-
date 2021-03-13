package CONTROLLER.USER.USERINFO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Cdonhang;
import MODEL.Donhang;
import MODEL.User;

/**
 * Servlet implementation class Loaddsdonhang
 */
@WebServlet("/Loaddsdonhang")
public class Loaddsdonhang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			ArrayList<Donhang> list=new ArrayList<Donhang>();
			HttpSession session=request.getSession();
	    	
	    	try
	    	{
	    		User u=(User)session.getAttribute("user");
	        	if(u!=null)
	        	{
				list=Cdonhang.getAlldonhangbyuser(u.getId_user(), 0);
				request.setAttribute("list", list);
	        	}
				//request.getRequestDispatcher(request.getContextPath()+"/admin/table.jsp").forward(request, response);
				
			}
			catch(Exception e){
				throw e;
			}
			request.getServletContext().getRequestDispatcher("/UserInfo/Dsdonhang.jsp").forward(request, response);
	}

}
