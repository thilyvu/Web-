package CONTROLLER.USER.PRODUCT;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DAO.Csanpham;
import MODEL.Sanpham;
/**
 * Servlet implementation class Loadproduct
 */
@WebServlet("/Loadproduct")
public class Loadproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    	ArrayList<Sanpham> list=new ArrayList<Sanpham>();
		try
		{
			list=Csanpham.dssanpham();
			 //JsonArray jsonArray1 = new Gson().toJsonTree(list).getAsJsonArray();	
			 JSONArray array=new JSONArray();
			 for(Sanpham x :list)
			 {		
				JSONObject obj=new JSONObject();
				obj.put("currentSlide", x.getCurrentSlide());
				obj.put("price", x.getPrice());
				obj.put("imagesrc",x.getImagesrc()!=null?x.getImagesrc().trim():"");
				obj.put("mau",x.getMau()!=null?x.getMau().trim():"");
				obj.put("mota", x.getMota()!=null?x.getMota().trim():"");
				obj.put("numberofstart",x.getNumberofstart());
				obj.put("name",x.getTen_sp());
				obj.put("loai",x.getId_loai());
				obj.put("sl_con",x.getSl_con());
				array.add(obj);
			 }
			 request.setAttribute("json", array);
			 request.getRequestDispatcher("./ProductPage/index.jsp").forward(request, resp);
		}
		catch(Exception e){ }
    	}
}
