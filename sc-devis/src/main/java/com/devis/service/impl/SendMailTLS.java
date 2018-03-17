package com.devis.service.impl;


import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.devis.service.ISendMailService;
import com.sun.mail.smtp.SMTPTransport;

@Service
public class SendMailTLS implements ISendMailService {
	
	// Basic Configuration 
	public final static String FROM = "antoine.fidalgo@canal-plus.com";
	public final static String FROMNAME = "antoine.fidalgo@canal-plus.com";
	
	public final static String USER_NAME = "ses-smtp-user.itboost";
	public final static String PASSWORD = "ArywvqKy8YaDe82uXUT+pEEeIX1N8lvK7VKr6+Q0HEs9";
	
	public final static String TO = "antoine.fidalgo@canal-plus.com";

	public static String HOST = "email-smtp.eu-west-1.amazonaws.com";
	 static final String CONFIGSET = "ConfigSet";
	 static final int PORT = 587;
	 
	 static final String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";
	
    static final String BODY = String.join(
    	    System.getProperty("line.separator"),
    	    "<h1>Amazon SES SMTP Email Test</h1>",
    	    "<p>This email was sent with Amazon SES using the ", 
    	    "<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
    	    " for <a href='https://www.java.com'>Java</a>."
    	);
	
    @Override
	public void sendMessageWithTemplaye() {
		
	    // Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	    // @SuppressWarnings("unused")
		// final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	    
	    // Configuration of the Server SMTP
        // Create a Properties object to contain connection configuration information.
     	Properties props = System.getProperties();
     	props.put("mail.transport.protocol", "smtp");
     	props.put("mail.smtp.port", PORT); 
     	props.put("mail.smtp.starttls.enable", "true");
     	props.put("mail.smtp.auth", "true");

         // Create a Session object to represent a mail session with the specified properties. 
     	Session session = Session.getDefaultInstance(props);
		 
        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress(FROM,""));
	        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
	        msg.setSubject(SUBJECT);
	        msg.setContent(BODY,"text/html");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        // Send the message.
        try
        {
        	Transport transport = session.getTransport();
            System.out.println("Sending...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, USER_NAME, PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        
    }
    
        
        

        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
   
		 
		 // Create the MimeMessage 
		 // final MimeMessage msg = new MimeMessage(session);
		  
		 /*
		    try {
		    	// Set the FROM and TO fields 
				msg.setFrom(new InternetAddress(USER_NAME));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO, false)); 
				msg.setSubject("1L18020003 - AMAZONAS FILMVERLEIH / STUDIOCANAL FILMS Ltd - Carry on Constable");
				msg.setSentDate(new Date());
				
				// Create the message Body Part
				BodyPart messageBodyPart = new MimeBodyPart();
				 messageBodyPart.setText("Hello," + 
				"\n\n" + "Please find enclosed the invoice related to the movie Carry on Constable for 12000.0 USD." + 
						 "\n" + "We look forward to your payment.,"
			                + "\n\n" + "Best regards."
			                + "\n" + "Studiocanal Accounting Dept."
			                + "\n\n" + "Mail generated automatically, thank you not to answer.");
				 
			    // Sending mail with attachment
			    MimeBodyPart attachementBodyPart = new MimeBodyPart();
			    Multipart multipart = new MimeMultipart();
			    String file = "/Users/ibrahimamadiodiodiagne/Desktop/1L18020003.pdf";
		        String fileName = "1L18020003.pdf";
		        DataSource source = new FileDataSource(file);
		        
		        attachementBodyPart.setDataHandler(new DataHandler(source));
		        attachementBodyPart.setFileName(fileName);
		        
		        multipart.addBodyPart(attachementBodyPart);
		        multipart.addBodyPart(messageBodyPart);
		        
		        // Set the content message and the attachment
		        msg.setContent(multipart);
				
			    // Transport
			     SMTPTransport t = (SMTPTransport)session.getTransport("smtp");
			    
			    // Connexion 
			     t.connect(HOST, USER_NAME, PASSWORD);
			    
		        
			    // Send the message and the attachment
			     t.sendMessage(msg, msg.getAllRecipients());
			    
			    // Here we close the Connexion 
			    t.close();
				    
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	*/	

    
	@SuppressWarnings({ "restriction" })
	public void sendMessage() {
		
	    Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	    @SuppressWarnings("unused")
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	    
	    // Configuration of the Server SMTP
		 Properties props = System.getProperties();
		 props.put("mail.smtp.starttls.enable", true);
		 props.put("mail.smtp.host", "smtp.gmail.com");
		 props.put("mail.smtp.user", USER_NAME);
		 props.put("mail.smtp.password", PASSWORD);
		 props.put("mail.smtp.port", "587");
		 props.put("mail.smtp.auth", true);
		 
		 // Session 
		 Session session = Session.getInstance(props,null);
		 
		 // Create the MimeMessage 
		 final MimeMessage msg = new MimeMessage(session);
		  
		    try {
		    	// Set the FROM and TO fields 
				msg.setFrom(new InternetAddress(USER_NAME));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO, false)); 
				msg.setSubject(" ******** Ceci est un test pour voir si l'envoi de mail fonctionne ********");
				msg.setSentDate(new Date());
				
				// Create the message Body Part
				BodyPart messageBodyPart = new MimeBodyPart();
				 messageBodyPart.setText("Hi All," + 
				"\n\n" + "Please find the invoice." + 
						 "\n\n" + "Regards,"
			                + "\n" + "Testing team");
				 
			    // Sending mail with attachment
			    MimeBodyPart attachementBodyPart = new MimeBodyPart();
			    Multipart multipart = new MimeMultipart();
			    String file = "/Users/ibrahimamadiodiodiagne/Desktop/CV IMD.pdf";
		        String fileName = "CV IMD.pdf";
		        DataSource source = new FileDataSource(file);
		        attachementBodyPart.setDataHandler(new DataHandler(source));
		        attachementBodyPart.setFileName(fileName);
		        multipart.addBodyPart(attachementBodyPart);
		        multipart.addBodyPart(messageBodyPart);
		        
		        // Set the content message and the attachment
		        msg.setContent(multipart);
				
			    // Transport
			     SMTPTransport t = (SMTPTransport)session.getTransport("smtp");
			    
			    // Connexion 
			     t.connect("smtp.gmail.com", USER_NAME, PASSWORD);
			    
		        
			    // Send the message and the attachment
			     t.sendMessage(msg, msg.getAllRecipients());
			    
			    // Here we close the Connexion 
			    t.close();
				    
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		  
	}

	@Override
	public void sendSimpleMessage() {
	    Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	    @SuppressWarnings("unused")
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	    
	    // Configuration of the Server SMTP
		 Properties props = System.getProperties();
		 props.put("mail.smtp.starttls.enable", true);
		 props.put("mail.smtp.host", HOST);
		 props.put("mail.smtp.user", USER_NAME);
		 props.put("mail.smtp.password", PASSWORD);
		 props.put("mail.smtp.port", "587");
		 props.put("mail.smtp.auth", true);
		 
		 // Session 
		 Session session = Session.getInstance(props,null);
		 
		 // Create the MimeMessage 
		 final MimeMessage msg = new MimeMessage(session);
		  
		    try {
		    	// Set the FROM and TO fields 
				msg.setFrom(new InternetAddress(USER_NAME));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO, false));
				msg.setSubject(" ******** Ceci est un test pour voir si l'envoi de mail fonctionne ********");
				msg.setText("Ceci est un test pour voir si l'envoi de mail fonctionne. ", "utf-8");
				
				msg.setSentDate(new Date());
				    
			    // Transport
			    SMTPTransport t = (SMTPTransport)session.getTransport("smtps");
			    
			    // Connexion 
			    t.connect(HOST, USER_NAME, PASSWORD);
			    
			    // Send the message
			    t.sendMessage(msg, msg.getAllRecipients());
			    
			    // Close the Connexion 
			    t.close();
				    
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	}

}
