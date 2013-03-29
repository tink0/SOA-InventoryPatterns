package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Jazda;
import sk.tuke.seregely.dipl.entity.model.JazdaHome;


@WebService()
public class HelloWorld {

	@WebMethod()
	public String sayHello(String name) {
	   try {
		Context ctx = new InitialContext();
		Session session = (Session) ctx.lookup("java:/Gmail");
		Message message = new MimeMessage(session);
		InternetAddress to[] = new InternetAddress[1];
		   to[0] = new InternetAddress("seregely8@gmail.com");  
		   message.setRecipients(Message.RecipientType.TO, to);
		    
		   message.setSubject("How to send a mail with GMAIL from JBoss AS");
		   message.setContent("Hello world", "text/plain");
		   Transport.send(message);
		  } catch (NamingException e) {
		   e.printStackTrace();
		  } catch (AddressException e) {
		   e.printStackTrace();
		  } catch (MessagingException e) {
		   e.printStackTrace();
		  }
		return "Hello " + name + "!";
	}
}
