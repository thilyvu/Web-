package Mail;

import java.util.Date;


import javax.mail.Message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

public class EmailUtil {
	public static void sendEmail(Session session, String toEmail, String subject, String text){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("send@songoku2.heliohost.us", "STVL"));

	      msg.setReplyTo(InternetAddress.parse("send@songoku2.heliohost.us", false));

	      msg.setSubject(subject, "UTF-8");

	      //msg.setText(text, "UTF-8");
	     // msg.setText(body, "text/html");
	      msg.setContent(text,"text/html; charset=utf-8");
	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
