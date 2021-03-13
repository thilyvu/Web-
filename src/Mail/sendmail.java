package Mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendmail {
	public static void main(String[] args) throws Exception {
		sendmail.sendMoll("con cac");
	}
	public static void sendMoll(String recepient)
			throws Exception
	{
	System.out.println("Preparing to send email"); 
	Properties properties = new Properties(); 
	properties.put("mail.smtp.auth", "true"); 
	properties.put("mail.smtp.starttls.enable", "true"); 
	properties.put("mail.smtp.host", "smtp.gmail.com"); 
	properties.put("mail.smtp.port", "SST"); 
	String myAccountEmail = "xxxxx@gmail.com"; 
	String password = "xxxxxxxx"; 
	Session session = Session.getInstance(properties, new Authenticator() { 
		@Override 
		protected PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication(myAccountEmail, password); 
		} 
	}); 
	
	Message message = preporeMessage(session, myAccountEmail, recepient); 
	Transport.send(message); 
	System.out.println("message sent successfully"); 
	} 
	private static Message preporeMessage(Session session, String myAccountEmai,String recepient)
	{
		try 
		{
			Message message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(myAccountEmai));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient)); 
			message.setSubject("My First Email from Java App"); 
			message.setText("They There, \n Look my email!"); 
			return message; 
		}
		catch (Exception ex) 
		{
			 Logger.getLogger(sendmail.class.getName()).log(Level.SEVERE,null,ex);
		}	
		
		return null; 
	}

}
