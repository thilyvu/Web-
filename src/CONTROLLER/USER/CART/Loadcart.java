package CONTROLLER.USER.CART;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DAO.Cgiohang;
import MODEL.User;

/**
 * Servlet implementation class Loadcart
 */
@WebServlet("/Loadcart")
public class Loadcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    	ArrayList<Object[]> list=new ArrayList<Object[]>();
    	HttpSession session=request.getSession();
    	
    	try
    	{
    		User u=(User)session.getAttribute("user");
        	if(u!=null)
        	{
	    		list=Cgiohang.Getgiohang(u.getId_user());
	    		JSONArray array= new JSONArray();
	    		 for(Object[] x:list)
	     	    {
	    			 JSONObject obj=new JSONObject();
	    				
	    				obj.put("id_user", x[0].toString());
	    				obj.put("id_sp",Integer.parseInt(x[1].toString()));
	    				obj.put("soluong",Integer.parseInt(x[2].toString()));
	    				obj.put("price",Float.parseFloat(x[4].toString()));
	    				obj.put("name",x[5].toString().trim());
	    				obj.put("sl_con",Integer.parseInt(x[6].toString()));
	    				obj.put("imagesrc",x[3].toString().trim());
	    				
	    				array.add(obj);
	     	    }
	    	
	    		request.setAttribute("json", array);
        	}
    	}
    	catch(Exception e){}
    	request.getRequestDispatcher("./Cart/Cart.jsp").forward(request, resp);
    	}
    	

}
