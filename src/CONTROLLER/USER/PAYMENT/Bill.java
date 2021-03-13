package CONTROLLER.USER.PAYMENT;

import java.io.IOException;
import java.time.LocalDateTime;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.Cchitietdonhang;
import DAO.Cdonhang;
import DAO.Cxacthucdonhang;
import MODEL.Chitietdonhang;
import MODEL.Donhang;
import MODEL.User;
import MODEL.Xacthucdonhang;
import Mail.SSLEmail;



/**
 * Servlet implementation class Bill
 */
@WebServlet("/Bill")
public class Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String mail_shipper="songoku2505@gmail.com";
  @Override
	protected void service(HttpServletRequest request, HttpServletResponse arg1) throws ServletException, IOException {
	  HttpSession session=request.getSession();
	   request.setCharacterEncoding("UTF-8");
	  User u=null;
	  int id=0;
	  Donhang x=null;
	  int check=0;
	  try
	  {
	 		u=(User)session.getAttribute("user");
	    	if(u!=null)
	    	{	
	    		
		 	 		x=new Donhang();
		 			x.setId_user(u.getId_user());
		 			x.setThoigian(LocalDateTime.now().withNano(0).toString());
		 			x.setTinhtrang("-1");
		 			x.setDiachi(request.getParameter("diachi"));
		 			x.setSdt(request.getParameter("sdt"));
		 			//out.print("<br> them don");
		 			id=Cdonhang.themdonhang(x);
		 			if(id==0)
		 			{
		 				id=Cdonhang.getiddonhangbyuser(u.getId_user());
		 			}
		 			//out.print("<br> id"+id);
		 			x.setId_donhang(id);
		 			if(request.getParameter("pay")==null ||request.getParameter("pay")=="")
		 			{
		 				//out.print("<br> pay");
		 		 		ArrayList<Chitietdonhang> list2 =new ArrayList<Chitietdonhang>();
		 				//list2.add(new Chitietdonhang(id,11,1));
		 		 		int tong=Integer.parseInt(request.getParameter("tong"));
		 		 		
		 				for(int i=0;i<tong;i++)
		 				{
		 					list2.add(new Chitietdonhang(id,Integer.parseInt(request.getParameter("id"+i)),Integer.parseInt(request.getParameter("soluong"+i))));			
		 				}
		 			
		 					if(Cchitietdonhang.themdsChitietdh(id, list2, u.getId_user())==1) 
		 					{
		 						//out.print("<br> pay0");
		 						check=1;
		 						request.setAttribute("them", "them don hang thanh cong");
		 						session.setAttribute("json", null);
		 						session.setAttribute("kiemtra", null);
		 					}
		 					else
		 						request.setAttribute("them", null);
		 			}
		 			else
		 			{
		 			//	System.out.print("add to pay");
		 			//sout.print("<br> add to pay");
		 				Chitietdonhang ct=new Chitietdonhang();
		 				ct.setId_donhang(id);
		 				ct.setSoluong(Integer.parseInt(request.getParameter("soluong"+0)));
		 				ct.setId_sp(Integer.parseInt(request.getParameter("id"+0)));
		 				if(Cchitietdonhang.themchitiet(ct,id)==1) 
		 				{
		 					//out.print("<br> add to pay 0");
		 					
		 					check=1;
		 					request.setAttribute("them", "them don hang thanh cong");
		 					session.setAttribute("json", null);
		 					session.setAttribute("kiemtra", null);
		 				}
		 				else
		 					request.setAttribute("them", null);
		 		
	    		}
	    		
	    	}
	  }
	  catch(Exception e){
	 	 System.out.print(e);
	 	 request.setAttribute("loi", "số lượng hàng trong kho không đủ");
	  }
	 // request.getRequestDispatcher("./LoadPayment").forward(request, arg1);
	  request.getServletContext().getRequestDispatcher("/Payment/Payment.jsp").forward(request,arg1 );;
		String bang="<table style=\"width=100%;border-collapse: collapse;\">";
		bang+="<tr>";				
		bang+="<th>Sản phẩm</th>";
		bang+="<th>Tên sản phẩm</th>";	
		bang+="<th>Giá</th>";
		bang+="<th>Số lượng</th>";
		bang+="<th>Tổng</th>";	
		bang+="</tr>";
		float tongbill=0;
		
		if(check>0)
		{
				ArrayList<Object[]> listct=Cchitietdonhang.GetChitietbyidDonhang(id);
				for(Object[] t:listct)
				{
					bang+="<tr>";		
					bang+="<td> <img src=\""+t[7].toString().trim()+"\" width=\"120px\"></td>";
					bang+="<td>"+t[6].toString().trim()+"</td>";
					bang+="<td>"+t[2].toString()+"</td>";
					bang+="<td>"+t[4].toString()+"</td>";
					bang+="<td>"+Float.parseFloat(t[2].toString())*Integer.parseInt(t[4].toString())+"</td>";
					bang+="</tr>";
					
					tongbill+=Float.parseFloat(t[2].toString())*Integer.parseInt(t[4].toString());
				}
				bang+=" </table>";
				
				String body="Xin chào "+u.getTenhienthi();
				body+="<br> Cảm ơn bạn đã đặt hàng tại STLV";
				body+="<br> Quý khách vui lòng kiểm tra lại đơn hàng";
				body+="<br> Địa chỉ nhận hàng: "+x.getDiachi()+" sdt: "+x.getSdt();
				body+="<br> Mã đơn hàng: "+id+" tổng hóa đơn: "+tongbill+" vào lúc: "+ x.getThoigian();
				body+="<br> Mọi thắc mắc vui lòng liên hệ songoku25@gmail.com";
				body+="<br>"+bang;
			
				
				SSLEmail.sendmail(u.getEmail(), "STVL:Xác nhận đơn hàng",body);
				
		}
	}

}
