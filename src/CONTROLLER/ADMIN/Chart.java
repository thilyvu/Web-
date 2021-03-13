package CONTROLLER.ADMIN;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DAO.Cthongke;



/**
 * Servlet implementation class Chart
 */
@WebServlet("/quanli/Chart")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    	try
    	{
    		//doanh thu 10 ngay
    		ArrayList<Object[]> list=Cthongke.Thongke10ngay();
    		JSONArray array= new JSONArray();
    		 for(int i=0;i<list.size(); i++)
    	       {
    			 JSONObject obj=new JSONObject();
    				
    				obj.put("ngay", list.get(i)[0].toString());
    				obj.put("tong", Float.parseFloat(list.get(i)[1].toString()));
    				array.add(obj);
    	       }
    		 //tong so san pham ban theo loai
    		 ArrayList<Object[]> list1=Cthongke.Loaisanpham();
    		JSONArray array1= new JSONArray();
    		 for(int i=0;i<list1.size(); i++)
    	       {
    			 JSONObject obj=new JSONObject();
    				
    				obj.put("loai", list1.get(i)[0].toString());
    				obj.put("tong", Integer.parseInt(list1.get(i)[1].toString()));
    				array1.add(obj);
    	       }
    		 //top 5 san pham ban chay
    		  ArrayList<Object[]> list2=Cthongke.top5sanpham();
    		JSONArray array2= new JSONArray();
    		 for(int i=0;i<list2.size(); i++)
    	       {
    			 JSONObject obj=new JSONObject();
    				
    				obj.put("tensp", list2.get(i)[0].toString());
    				obj.put("tong", Float.parseFloat(list2.get(i)[1].toString()));
    				obj.put("soluong", Integer.parseInt(list2.get(i)[2].toString()));
    				array2.add(obj);
    	       }
    		 //
    		 request.setAttribute("json2", array2);
    		 request.setAttribute("json1", array1);
    		 request.setAttribute("json", array);
    	}
    	catch(Exception e){System.out.print(e);}
    	 request.getServletContext().getRequestDispatcher("/admin/Chart.jsp").forward(request, resp);;
    	}
   

}
