package CONTROLLER.USER.LOGIN;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cuser;
import DAO.Cxacthucuser;
import MODEL.User;
import MODEL.Xacthucuser;
import Mail.SSLEmail;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			private static boolean isPhoneValid(String s) {
				String regex = "/(84|0[3|5|7|8|9])+([0-9]{8})\b"; // XXX-XXX-XXXX
				return s.matches(regex);
			}
			public static boolean isValidEmail(String email) {
				String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				return email.matches(regex);
		}
			public int getSpecialCharacterCount(String s) {
				if (s == null || s.trim().isEmpty()) {
						System.out.println("Incorrect format of string");
						return 0;
				}
				Pattern p = Pattern.compile("[^\w<>]*(?:[^<>"'\s]*:)?[^\w<>]*(?:\W*s\W*c\W*r\W*i\W*p\W*t|\W*f\W*o\W*r\W*m|\W*s\W*t\W*y\W*l\W*e|\W*s\W*v\W*g|\W*m\W*a\W*r\W*q\W*u\W*e\W*e|(?:\W*l\W*i\W*n\W*k|\W*o\W*b\W*j\W*e\W*c\W*t|\W*e\W*m\W*b\W*e\W*d|\W*a\W*p\W*p\W*l\W*e\W*t|\W*p\W*a\W*r\W*a\W*m|\W*i?\W*f\W*r\W*a\W*m\W*e|\W*b\W*a\W*s\W*e|\W*b\W*o\W*d\W*y|\W*m\W*e\W*t\W*a|\W*i\W*m\W*a?\W*g\W*e?|\W*v\W*i\W*d\W*e\W*o|\W*a\W*u\W*d\W*i\W*o|\W*b\W*i\W*n\W*d\W*i\W*n\W*g\W*s|\W*s\W*e\W*t|\W*i\W*s\W*i\W*n\W*d\W*e\W*x|\W*a\W*n\W*i\W*m\W*a\W*t\W*e)[^>\w])|(?:<\w[\s\S]*[\s\0\/]|['"])(?:formaction|style|background|src|lowsrc|ping|on(?:d(?:e(?:vice(?:(?:orienta|mo)tion|proximity|found|light)|livery(?:success|error)|activate)|r(?:ag(?:e(?:n(?:ter|d)|xit)|(?:gestur|leav)e|start|drop|over)?|op)|i(?:s(?:c(?:hargingtimechange|onnect(?:ing|ed))|abled)|aling)|ata(?:setc(?:omplete|hanged)|(?:availabl|chang)e|error)|urationchange|ownloading|blclick)|Moz(?:M(?:agnifyGesture(?:Update|Start)?|ouse(?:PixelScroll|Hittest))|S(?:wipeGesture(?:Update|Start|End)?|crolledAreaChanged)|(?:(?:Press)?TapGestur|BeforeResiz)e|EdgeUI(?:C(?:omplet|ancel)|Start)ed|RotateGesture(?:Update|Start)?|A(?:udioAvailable|fterPaint))|c(?:o(?:m(?:p(?:osition(?:update|start|end)|lete)|mand(?:update)?)|n(?:t(?:rolselect|extmenu)|nect(?:ing|ed))|py)|a(?:(?:llschang|ch)ed|nplay(?:through)?|rdstatechange)|h(?:(?:arging(?:time)?ch)?ange|ecking)|(?:fstate|ell)change|u(?:echange|t)|l(?:ick|ose))|m(?:o(?:z(?:pointerlock(?:change|error)|(?:orientation|time)change|fullscreen(?:change|error)|network(?:down|up)load)|use(?:(?:lea|mo)ve|o(?:ver|ut)|enter|wheel|down|up)|ve(?:start|end)?)|essage|ark)|s(?:t(?:a(?:t(?:uschanged|echange)|lled|rt)|k(?:sessione|comma)nd|op)|e(?:ek(?:complete|ing|ed)|(?:lec(?:tstar)?)?t|n(?:ding|t))|u(?:ccess|spend|bmit)|peech(?:start|end)|ound(?:start|end)|croll|how)|b(?:e(?:for(?:e(?:(?:scriptexecu|activa)te|u(?:nload|pdate)|p(?:aste|rint)|c(?:opy|ut)|editfocus)|deactivate)|gin(?:Event)?)|oun(?:dary|ce)|l(?:ocked|ur)|roadcast|usy)|a(?:n(?:imation(?:iteration|start|end)|tennastatechange)|fter(?:(?:scriptexecu|upda)te|print)|udio(?:process|start|end)|d(?:apteradded|dtrack)|ctivate|lerting|bort)|DOM(?:Node(?:Inserted(?:IntoDocument)?|Removed(?:FromDocument)?)|(?:CharacterData|Subtree)Modified|A(?:ttrModified|ctivate)|Focus(?:Out|In)|MouseScroll)|r(?:e(?:s(?:u(?:m(?:ing|e)|lt)|ize|et)|adystatechange|pea(?:tEven)?t|movetrack|trieving|ceived)|ow(?:s(?:inserted|delete)|e(?:nter|xit))|atechange)|p(?:op(?:up(?:hid(?:den|ing)|show(?:ing|n))|state)|a(?:ge(?:hide|show)|(?:st|us)e|int)|ro(?:pertychange|gress)|lay(?:ing)?)|t(?:ouch(?:(?:lea|mo)ve|en(?:ter|d)|cancel|start)|ime(?:update|out)|ransitionend|ext)|u(?:s(?:erproximity|sdreceived)|p(?:gradeneeded|dateready)|n(?:derflow|load))|f(?:o(?:rm(?:change|input)|cus(?:out|in)?)|i(?:lterchange|nish)|ailed)|l(?:o(?:ad(?:e(?:d(?:meta)?data|nd)|start)?|secapture)|evelchange|y)|g(?:amepad(?:(?:dis)?connected|button(?:down|up)|axismove)|et)|e(?:n(?:d(?:Event|ed)?|abled|ter)|rror(?:update)?|mptied|xit)|i(?:cc(?:cardlockerror|infochange)|n(?:coming|valid|put))|o(?:(?:(?:ff|n)lin|bsolet)e|verflow(?:changed)?|pen)|SVG(?:(?:Unl|L)oad|Resize|Scroll|Abort|Error|Zoom)|h(?:e(?:adphoneschange|l[dp])|ashchange|olding)|v(?:o(?:lum|ic)e|ersion)change|w(?:a(?:it|rn)ing|heel)|key(?:press|down|up)|(?:AppComman|Loa)d|no(?:update|match)|Request|zoom))[\s\0]*=]");
				Matcher m = p.matcher(s);
			 // boolean b = m.matches();
				boolean b = m.find();
				if (b)
					 System.out.println("There is a special character in my string ");
				else
						System.out.println("There is no special char.");
				return 0;
		}
			try
   		{
   			String email = request.getParameter("email");
   			String phone = request.getParameter("phone");
   			String password = request.getParameter("mk");
   			String password1 = request.getParameter("mk1");
   			if (isValidEmail(email)&& isPhoneValid(phone)&& getSpecialCharacterCount(email)==0 && getSpecialCharacterCount(phone)==0)
				 {
					if(!password.equals(password1))
					{
						request.setAttribute("matkhau", "Mật khẩu phải trùng nhau");	
					}
					else
					{
						User x=new User();
						x.setId_user(email);
						x.setSdt(phone);
						x.setEmail(email);
						x.setPass(password);
						x.setPermission("0");
						x.setKichhoat("0");
						x.setAvatar("https://image.freepik.com/free-vector/cute-blue-dolphin-avatar_79416-75.jpg");
						if(Cuser.themUser(x)>0)
						{
							Xacthucuser xt=new Xacthucuser();
							xt.setId_user(x.getId_user());
							xt.setGmail(x.getEmail());
							int code = (int) Math.floor(((Math.random() * 899999) + 100000));
							xt.setMaxacthuc(""+code);
							xt.setTinhtrang("0");
							int i=Cxacthucuser.themxacthuc(xt);
							if(i>0)
							{
								String body="";
								body+="<br>Chúc mừng bạn đã đăng kí tài khoản tại STVL";
								body+="<br>Mời bạn vui lòng click vào link dưới vào đây để hoàn tất đăng kí";
								body+="<br> <a href=\"https://stvlshop.herokuapp.com/Cregister?id="+i+"&maxacthuc="+code+"\">click vào đây</a>";
								SSLEmail.sendmail(x.getEmail(), "Xác nhận tài khoản", body);
								request.setAttribute("taikhoan", "Chúng tôi vửa gửi tin nhắn xác nhận đến email của bạn");
							}
						}
						else
							request.setAttribute("taikhoan", "Tài khoản đã tồn tại hoặc chưa kích hoạt");	
					}

				 }
   			else{
					request.setAttribute("taikhoan", "Tài khoản email hoặc số điện thoại của bạn không đúng định dạng vui lòng kiểm tra lại");	
				 }
   		}
   		catch (Exception e) {
   			// TODO: handle exception
   		}
   		request.getRequestDispatcher("./login/registration.jsp").forward(request, response);
    }
       boolean pat(String mau,String vanban)
   	{
   		Pattern pattern = Pattern.compile(mau);
   	    Matcher matcher = pattern.matcher(vanban);
   	    boolean matches = matcher.matches(); 
   	    return matches;
   	}
}
