package CONTROLLER.USER.USERINFO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cdonhang;
import DAO.Cxacthucdonhang;
import MODEL.Donhang;
import MODEL.Xacthucdonhang;
import Mail.SSLEmail;

/**
 * Servlet implementation class cpayment
 */
@WebServlet("/cpayment")
public class cpayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String mail_shipper="songoku2505@gmail.com";
   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
			String huy=req.getParameter("huy");
			String maxacthuc=req.getParameter("maxacthuc");
			int id=Integer.parseInt(req.getParameter("id"));
			if(huy==""||huy==null)
			{
				if(maxacthuc!=""&&maxacthuc.length()==6)
				{
					Xacthucdonhang xt= Cxacthucdonhang.Getxacthucbyid(id);
					if(maxacthuc.equals(xt.getMaxacthuc())&&xt.getTinhtrang().equals("0"))
					{
						if(Cdonhang.suadonhangbyid(xt.getId_donhang(), "2", "")>0)
						{
							int code = (int) Math.floor(((Math.random() * 899999) + 100000));
							xt.setMaxacthuc(code+"");
							xt.setTinhtrang("1");
							if(Cxacthucdonhang.suaxacthuc(xt)>0)
							{
								req.setAttribute("xacthuc", "Xác thực đã nhận đơn hàng");
								Donhang dh=Cdonhang.getdonhangbyid(xt.getId_donhang());
								String body="Xác nhận giao hàng";
								body+="<br>Mã đơn hàng: " +xt.getId_donhang();
								body+="<br>Tổng thanh toán: "+dh.getTong_thanh_toan();
								body+="<br>Địa chỉ giao hàng: "+dh.getDiachi();
								body+="<br>Sdt người nhận: "+dh.getSdt();
								
								body+="<br><a href=\"https://localhost:8080/shop/cpayment?maxacthuc="+code+"&id="+id+"\"><button>Xác nhận đã giao</button></a>";
								body+="<br><a href=\"https://localhost:8080/shop/cpayment?maxacthuc="+code+"&id="+id+"&huy=1\"><button>Khách hàng đã hủy nhận hàng</button></a>";
								SSLEmail.sendmail(mail_shipper, "Nhận đơn hàng", body);
							}
						}
					}
					else if(maxacthuc.equals(xt.getMaxacthuc())&&xt.getTinhtrang().equals("1"))
							{
								
									if(Cdonhang.suadonhangbyid(xt.getId_donhang(), "1", "")>0)
									{
										xt.setTinhtrang("2");
										xt.setMaxacthuc("999999");
										if(Cxacthucdonhang.suaxacthuc(xt)>0)
										{
											req.setAttribute("xacthuc", "Xác thực đã giao hàng");
											Donhang dh=Cdonhang.getdonhangbyid(xt.getId_donhang());
											String body="Xác nhận đã giao hàng";
											body+="<br>Mã đơn hàng: " +xt.getId_donhang();
											body+="<br>Tổng thanh toán: "+dh.getTong_thanh_toan();
											body+="<br>Địa chỉ giao hàng: "+dh.getDiachi();
											body+="<br>Sdt người nhận: "+dh.getSdt();
											SSLEmail.sendmail(mail_shipper, "Xác nhận giao hàng thành công", body);
										}
									}
							}
					else 
					{
						req.setAttribute("xacthuc", "Xác thực đã giao đơn hàng");
					}
				}
			}
			else
			{
				if(maxacthuc!=""&&maxacthuc.length()==6)
				{
					Xacthucdonhang xt= Cxacthucdonhang.Getxacthucbyid(id);
					if(maxacthuc.equals(xt.getMaxacthuc())&&xt.getTinhtrang().equals("1"))
					{
						if(Cdonhang.suadonhangbyid(xt.getId_donhang(), "-2", "")>0)
						{
							xt.setTinhtrang("-1");
							xt.setMaxacthuc("000000");
							if(Cxacthucdonhang.suaxacthuc(xt)>0)
							{
								req.setAttribute("xacthuc", "Xác thực đã hủy giao hàng");
								Donhang dh=Cdonhang.getdonhangbyid(xt.getId_donhang());
								String body="Xác nhận hủy giao hàng";
								body+="<br>Mã đơn hàng: " +xt.getId_donhang();
								body+="<br>Tổng thanh toán: "+dh.getTong_thanh_toan();
								body+="<br>Địa chỉ giao hàng: "+dh.getDiachi();
								body+="<br>Sdt người nhận: "+dh.getSdt();
								SSLEmail.sendmail(mail_shipper, "Xác thực đã hủy giao hàng", body);
							}
						}
					}
					
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		req.getServletContext().getRequestDispatcher("/UserInfo/xacthuc.jsp").forward(req, resp);
	}

}
