package CONTROLLER.ADMIN;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Cuser;
import MODEL.User;

/**
 * Servlet implementation class editadmin
 */
@WebServlet("/editadmin")
public class editadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession session=request.getSession();  
	   try
	   {
		   User u=(User)session.getAttribute("admin");
		   String ten=request.getParameter("ten");
		   String sdt=request.getParameter("sdt");
		   String email=request.getParameter("mail");
		   String ngaysinh=request.getParameter("ngaysinh");
		   String diachi=request.getParameter("diachi");
		   String image=request.getParameter("link");
		   u.setTenhienthi(ten);
		   u.setSdt(sdt);
		   u.setEmail(email);
		   u.setNgaysinh(ngaysinh);
		   u.setDiachi(diachi);
		   u.setAvatar(image);
		   
		   if(Cuser.suaUser(u)>0)
		   {
			   session.setAttribute("admin", u);
		   }
	   }
	   catch (Exception e) {
		// TODO: handle exception
		   
	}
	   resp.sendRedirect(request.getContextPath()+"/quanli/profile");
	}

}
