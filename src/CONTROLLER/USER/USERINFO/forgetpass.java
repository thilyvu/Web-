package CONTROLLER.USER.USERINFO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cuser;
import MODEL.User;
import Mail.SSLEmail;


/**
 * Servlet implementation class forgetpass
 */
@WebServlet("/forgetpass")
public class forgetpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			public static boolean isValidEmail(String email) {
				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
		}
		try
		{
			String email=req.getParameter("email");
			if(email!=null && email!="")
			{
				if( isValidEmail(email) )
				{
					User u=Cuser.getUser(email);
					String body="Gửi "+u.getTenhienthi();
					body+="<br> Bạn vửa tiến hành quên mật khẩu";
					body+="<br> Mật khẩu của bạn là: "+u.getPass();
					body+="<br> Mọi thắc mắc vui lòng liên hệ songoku2505@gmail.com";
					SSLEmail.sendmail(u.getEmail(), "Quên mật khẩu", body);
					req.setAttribute("mail", "Chúng tôi vừa gửi mật khẩu của bạn vào email mà bạn đăng kí");
				}
				else{
					req.setAttribute("mail", "Email của bạn sai định dạng vui lòng kiểm tra lại");
				}
			
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		req.getServletContext().getRequestDispatcher("/login/forgetpass.jsp").forward(req, resp);
	}

}
