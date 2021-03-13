package CONTROLLER.ADMIN;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Csanpham;
import MODEL.Sanpham;

/**
 * Servlet implementation class dssanpham
 */
@WebServlet(urlPatterns = {"/quanli", "/quanli/dssanpham","/quanli/dssanpham/*","/quanli/dssanpham/insert","/quanli/dssanpham/update","/quanli/dssanpham/delete"})
public class dssanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String action=request.getServletPath();
		 
		      try {
		          switch (action) {
		          		case "/quanli/dssanpham/insert":
		          			insertsp(request, response);
		          		break;
		          		case "/quanli/dssanpham/update":
		          			updatesp(request, response);
		          		break;
		          		case "/quanli/dssanpham/delete":
		          			deletesp(request, response);
		          		break;
		              default:
		                  listsp(request, response);
		                  break;
		          }
		      } catch (Exception ex) {
		         
		      }
	}
   private void listsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   
 	{
			int pagenumber=1;
			int trang=1;
			
			ArrayList<Sanpham> list=new ArrayList<Sanpham>();
			try{
				trang=Csanpham.tongsp();
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
				list=Csanpham.ds10sanpham(pagenumber-1);
				
				
				
				request.setAttribute("trang", trang/10);
				request.setAttribute("list", list);
				request.setAttribute("so", pagenumber);
				//request.getRequestDispatcher(request.getContextPath()+"/admin/table.jsp").forward(request, response);
				
			}
			catch(Exception e){
				throw e;
			}
			request.getServletContext().getRequestDispatcher("/admin/table.jsp").forward(request, response);
			
	}
   private void updatesp(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	Sanpham sp=new Sanpham();

		    	String[] m={"Áo","Quần","Đầm","Túi"};
		    	try
		    	{
		    		int idsp=request.getParameter("idsp")!=null?Integer.parseInt(request.getParameter("idsp")):0;
		    		sp=Csanpham.getspbyid(idsp);	
		    	}
		    	catch(Exception e){}
		    	
				request.setAttribute("sanpham", sp);
				request.setAttribute("loai", m);
				
				request.getServletContext().getRequestDispatcher("/admin/Editsp.jsp").forward(request, response);
		    }
		    private void insertsp(HttpServletRequest request, HttpServletResponse response)
		    	    throws SQLException, IOException, ServletException {
		    	    	String[] m={"Áo","Quần","Đầm","Túi"};
		    			request.setAttribute("loai", m);
		    			request.getServletContext().getRequestDispatcher("/admin/Editsp.jsp").forward(request, response);
		    	    }
		    private void deletesp(HttpServletRequest request, HttpServletResponse response)
		    	    throws SQLException, IOException, ServletException {
		    			int page=1;
				    	try
				    	{
				    		page=request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):1;
				    		int idsp=request.getParameter("idsp")!=null?Integer.parseInt(request.getParameter("idsp")):0;
				    		if(Csanpham.xoasp(idsp)==1)
				    		{
				    			request.setAttribute("xoa", "xoa thanh cong");
				    		}
				    		else 
				    			request.setAttribute("xoa", "xoa that bai");
				    		
				    		
				    	}
				    	catch(Exception e){}
				    	listsp(request,response);
				    	request.getServletContext().getRequestDispatcher("/quanli?page="+page).forward(request, response);
		    	    }
		    


}
