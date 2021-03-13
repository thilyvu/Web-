package CONTROLLER.USER.LOGIN;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cuser;
import DAO.Cxacthucuser;
import MODEL.Xacthucuser;

/**
 * Servlet implementation class Cregister
 */
@WebServlet("/Cregister")
public class Cregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try
		{
			int id=Integer.parseInt(req.getParameter("id"));
			String maxacthuc=req.getParameter("maxacthuc");
			if(maxacthuc!=""&& maxacthuc!=""&&maxacthuc.length()==6)
			{
				Xacthucuser xt=Cxacthucuser.Getxacthucbyid(id);
				if(xt.getMaxacthuc().equals(maxacthuc))
				{
					if(Cuser.suaUserbyid(xt.getId_user(), "1")>0)
					{
						xt.setTinhtrang("1");
						if(Cxacthucuser.suaxacthuc(xt)>0)
						{
							req.setAttribute("dangki", "đăng kí thành công");
						}
					}
				}
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		req.getServletContext().getRequestDispatcher("/login/login.jsp").forward(req, resp);
	}

}
