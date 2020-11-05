package web;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmailValidate")
public class EmailValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void Validate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String url="/EmailForm.jsp";
		String NumberOfProduct = request.getParameter("number");
		String NameofCustomer = request.getParameter("customerName");
		String Phone = request.getParameter("phone");
		String Email = request.getParameter("email");
		String ExpirationDate=request.getParameter("ExpirationDate");
		String ExpirationYear=request.getParameter("ExpirationYear");
		String number= request.getParameter("expirationnumber");
				
		String ra="";
		String mo="";
		String mang[]={};
		
		// condition for NumberOfProduct
		if (NumberOfProduct.equals("")) {
			
			request.setAttribute("number", "You must type your number of products you want to purchase");
		}
		else {
			int quantitynumber=0;
			try {
				quantitynumber=Integer.parseInt(NumberOfProduct);
				if(quantitynumber>0)
				{
				request.setAttribute("CustomerNumberBackUp",quantitynumber );
				}
				else {
					request.setAttribute("number", "Your input should be integer");
				}
			}
			catch(NumberFormatException ex)
			{
				request.setAttribute("number", "Your input should be integer");
			}
		}
		// condition for NameofCustomer 
		request.setAttribute("NameBackUp",NameofCustomer);
		
		
		// condition for ExpirationDate
		request.setAttribute("ExpirationDateBU",ExpirationDate);
		request.setAttribute("ExpirationYearBU",ExpirationYear);
		
		// condition for Phone
		Pattern patternObject =Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})\\b");
		Matcher matcherObject =patternObject.matcher(Phone);
		if(!matcherObject.matches()) {
			request.setAttribute("phone", "Your phone number is not true format please check it again");
		}
		else {
			request.setAttribute("phoneBackUp",Phone);
		}
		
		// condition for Email
		Pattern EmailPattern =Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
		Matcher MatcherEmail =EmailPattern.matcher(Email);
		if(!MatcherEmail.matches()) {
			request.setAttribute("email", "Your email is not true format please check it again");
		}
		else
		{
			request.setAttribute("emailBackup", Email);
		}
		
		
		/// condition for radio button
		if(request.getParameter("ra")!=null){
			 ra=request.getParameter("ra");
			 request.setAttribute("bura",ra);
			 
		}
		if(request.getParameter("mo")!=null) {
			mo=request.getParameter("mo");
			 request.setAttribute("bumo",mo);
		}
		if(request.getParameterValues("equ")!=null) {
			mang=request.getParameterValues("equ");
		}
		
		/// condition for number
		
		Pattern CreditCardPattern =Pattern.compile("^4[0-9]{12}(?:[0-9]{3})?$");
		Matcher MatcherCreditcard =CreditCardPattern.matcher(number);
		if(!MatcherCreditcard.matches()) {
			request.setAttribute("CreditCardNumber", "Your credit card is not true format please check it again");
		}
		else
		{
			request.setAttribute("CreditCardNumberBU", number);
		}
		

		
		/////CustomerNumberBackUp/////////
		if(request.getAttribute("CustomerNumberBackUp")!=null 
				&& request.getAttribute("NameBackUp")!=null 
				&&request.getAttribute("emailBackup")!=null
				&&request.getAttribute("phoneBackUp")!=null 
				&& request.getAttribute("CreditCardNumberBU")!=null 
				 
				) 
				{	
					url="/EmailFormresult.jsp";
				}
		RequestDispatcher dispatcherObject= getServletContext().getRequestDispatcher(url);
		dispatcherObject.forward(request, response);
	}
    public EmailValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Validate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
