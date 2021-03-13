package CONTROLLER.USER.USERINFO;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Cuser;
import MODEL.User;

//import org.apache.jasper.TrimSpacesOption;

/**
 * Servlet implementation class userInfoControl
 */
@WebServlet("/userInfoControl")
public class userInfoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInfoControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	HttpSession session=request.getSession();
    	 String url ="./UserInfo/userInfo.jsp";
    	try
    	{
		        String usernameValue= ((String)request.getParameter("name")); 
		        String usernamedisplayValue= ((String)request.getParameter("usernamedisplay"));
		        String emailValue= ((String)request.getParameter("email"));
		        String phoneValue= ((String)request.getParameter("phone"));
		        String addressValue= ((String)request.getParameter("address"));
		        String birthdayValue= ((String)request.getParameter("birthday"));
		        String imageValue= ((String) request.getParameter("selectImage"));
		        String txtImageValue= ((String)request.getParameter("txtImage"));
		        //Url for transform
		       
		        int flat=1;
		        //Validate data not blank
		        if(usernameValue.equals(""))
		        {
		        	 //  url="/userInfo.jsp";
		        	   flat=0;
		            request.setAttribute("usernameError",""+ "*Tên không được để trống");
		        }
		        if(usernamedisplayValue.equals(""))
		        {
		        	flat=0;
		        	  // url="/userInfo.jsp";
		            request.setAttribute("usernamedisplayError",""+ "*Tên hiển thị không được để trống");
		        }
		        if(addressValue.equals(""))
		        {
		        	flat=0;
		        	 //  url="/userInfo.jsp";
		            request.setAttribute("addressError",""+ "*Địa chỉ giao hàng mặc định phải có");
		        }
		        
		        //Valiate Phone number
		        Pattern patternPhone = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
		        Matcher matchPhone=patternPhone.matcher(phoneValue);
		        if(!matchPhone.matches())
		        {
		           
		        	flat=0;
		        	  // url="./Userinfo/userInfo.jsp";
		            request.setAttribute("phoneError","*Số điện thoại phải theo định dạng xxx-xxx-xxxx ");
		        }
		       
		        Pattern patternEmail = Pattern.compile("\\w+@\\w+(\\.\\w+)*");
		        Matcher matchEmail=patternEmail.matcher(emailValue);
		        if(!matchEmail.matches())
		        {
		        	flat=0;
		       
		            //url="/userInfo.jsp";
		            request.setAttribute("emailError","*Vui lòng nhập gmail chính xác ");
		        }
		        
		        //ReFill web
		        
		        request.setAttribute("name", usernameValue);
		        request.setAttribute("usernamedisplay", usernamedisplayValue);
		        request.setAttribute("email", emailValue);
		        request.setAttribute("phone", phoneValue);
		        request.setAttribute("address", addressValue);
		        request.setAttribute("birthday", birthdayValue);
		        request.setAttribute("txtImage", txtImageValue);
		       request.setAttribute("selectImage", imageValue);
		       if(flat==1)
		       {
		    	   User u=(User)session.getAttribute("user");
		        	if(u!=null)
		        	{
		        		u.setTenhienthi(usernamedisplayValue);
		        		u.setEmail(emailValue);
		        		u.setSdt(phoneValue);
		        		u.setDiachi(addressValue);
		        		u.setNgaysinh(birthdayValue);
		        		u.setAvatar(request.getParameter("anh"));
		        		
		        		if(Cuser.suaUser(u)>0)
		        		{
		        			 request.setAttribute("selectImage", u.getAvatar());
		        			request.setAttribute("successfull", 1);
		        			url="./Loasuserinfo";
		        		}
		        	}
		    	  
		       }
		    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
