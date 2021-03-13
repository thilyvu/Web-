package CONTROLLER.ADMIN;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Csanpham;
import MODEL.Sanpham;

/**
 * Servlet implementation class Updateproduct
 */
@WebServlet("/Updateproduct")
public class Updateproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id=0;
    	try
    	{
    		Sanpham x=new Sanpham();
			x.setTen_sp(request.getParameter("ten").trim());
			x.setPrice(Float.parseFloat(request.getParameter("gia")));
			x.setImagesrc(request.getParameter("link").trim());
			x.setSl_con(Integer.parseInt(request.getParameter("soluong")));
			x.setMau(request.getParameter("mau").trim());
			x.setId_loai(Integer.parseInt(request.getParameter("loai")));
			x.setCurrentSlide(Integer.parseInt(request.getParameter("id")));
			x.setMota(request.getParameter("mota").trim());
			x.setNha_sx(request.getParameter("nsx").trim());
			Csanpham.suasp(x);
			
			id=x.getCurrentSlide();
    	}
    	catch(Exception e){}
    	    	
    			response.sendRedirect(request.getContextPath()+"/quanli/dssanpham/update?idsp="+id);
    	    }


}
