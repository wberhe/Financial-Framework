package banking;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import framework.ICustomer;
import framework.IPredicate;

public class EmailUtil {

	public static void sendEmail(double amount, ICustomer customer,
			IPredicate predicate) {
		// TODO Auto-generated method stub
		
		boolean result = predicate.check(amount, customer);
		if(result)
			notify(customer,amount);
		
	}

	private static void notify(ICustomer customer,double amount) {
		// TODO Auto-generated method stub
		//System.out.println("Sending Email to user email: "+email);
		final String username = "mum.asd2014@gmail.com";
		final String password = "mumasd2014";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mum.asd2014@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(customer.getEmail()));
			message.setSubject("Account Update");
			message.setText("Dear "+customer.getName()+",\n"
				+ "Your Account number "+customer.getAccount().getAccnum()+" has been updated with amount = $"+amount+".\n Thanks,\n Bank Admin");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
