package sk.tuke.seregely.dipl.services.utilities;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebService()
public class EmailSender {
	
	@WebMethod()
	public void send(String recipient, String subject, String content) {
	   try {
			Context ctx = new InitialContext();
			Session session = (Session) ctx.lookup("java:/Gmail");
			Message message = new MimeMessage(session);
			
			InternetAddress to[] = new InternetAddress[1];
			   to[0] = new InternetAddress(recipient);  
			   message.setRecipients(Message.RecipientType.TO, to);
			    
			   message.setSubject(subject);
			   message.setContent(content, "text/plain");
			   Transport.send(message);
			  } catch (NamingException e) {
			   e.printStackTrace();
			  } catch (AddressException e) {
			   e.printStackTrace();
			  } catch (MessagingException e) {
			   e.printStackTrace();
			  }
			return ;
		}
	
	@WebMethod()
	public void sendConfirm(String recipient) {
		send(recipient, "schválené", "Vase jazdy za tento mesiac boli schválené");
	}

}
