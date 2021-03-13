package CONTROLLER.ADMIN;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cchitietdonhang;

/**
 * Servlet implementation class Loadproductpayment
 */
@WebServlet("/quanli/Loadproductpayment")
public class Loadproductpayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try
    		{
    			int iddh=Integer.parseInt(request.getParameter("iddh"));
    			ArrayList<Object[]> list=Cchitietdonhang.GetChitietbyidDonhang(iddh);
    			request.setAttribute("list", list);
    		}
    		catch (Exception e) {
				// TODO: handle exception
			}
    		request.getServletContext().getRequestDispatcher("/admin/productpayment.jsp").forward(request, response);
    	}

}
