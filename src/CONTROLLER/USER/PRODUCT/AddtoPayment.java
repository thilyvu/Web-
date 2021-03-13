package CONTROLLER.USER.PRODUCT;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class AddtoPayment
 */
@WebServlet("/AddtoPayment")
public class AddtoPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();  
   	try{
			 
			 int id_sp =Integer.parseInt( request.getParameter("addcart"));
			 int  soluong =Integer.parseInt(request.getParameter("soluong"));
			 
			 float price=Float.parseFloat(request.getParameter("price"));
			 String name=request.getParameter("name");
			 String image=request.getParameter("img");

			JSONArray array=new JSONArray();
			JSONObject obj=new JSONObject();
			obj.put("name",name);
			obj.put("id_sp",id_sp);
			obj.put("soluong",soluong);
			obj.put("price", price);
			obj.put("imagesrc",image);
			
			
			array.add(obj);

			 session.setAttribute("json", array);
			 request.setAttribute("pay", 1);
			 
		 }
		 catch(Exception e)
		 {
			 
		 }
   	request.getServletContext().getRequestDispatcher("/Payment/Payment.jsp").forward(request, response);;
   		//response.sendRedirect(request.getContextPath()+"/LoadPayment");
	}

}
