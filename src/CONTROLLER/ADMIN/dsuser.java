package CONTROLLER.ADMIN;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.Cuser;

import MODEL.User;

/**
 * Servlet implementation class dsuser
 */
@WebServlet(urlPatterns = {"/quanli/dsuser"})
public class dsuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int pagenumber=1;
		int trang=1;
		
		ArrayList<User> list=new ArrayList<User>();
		try{
			trang=Cuser.tongsp();
			if(trang%10!=0)
				trang=trang+10;
			if(request.getParameter("page")!=null)
			{
				pagenumber=Integer.parseInt(request.getParameter("page"));
				if(pagenumber<1)
					pagenumber=1;
				if(pagenumber>=trang/10)
					pagenumber=trang/10;
			}
			list=Cuser.ds10User(pagenumber-1);
			
			
			
			request.setAttribute("trang", trang/10);
			request.setAttribute("list", list);
			request.setAttribute("so", pagenumber);
			//request.getRequestDispatcher(request.getContextPath()+"/admin/table.jsp").forward(request, response);
			
		}
		catch(Exception e){
			throw e;
		}
		request.getServletContext().getRequestDispatcher("/admin/Usertable.jsp").forward(request, response);
	}

}
