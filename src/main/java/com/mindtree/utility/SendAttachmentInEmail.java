package com.mindtree.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.mindtree.reusuablecomponents.AllObjects;
import com.mindtree.reusuablecomponents.Report;


public class SendAttachmentInEmail extends AllObjects{

	public static void mail() throws IOException, AddressException, MessagingException {
		Properties prop=new Properties();
		String propFile=System.getProperty("user.dir")+"\\config.properties";
		FileInputStream input=new FileInputStream(propFile);
		prop.load(input);
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.smtp.host",prop.getProperty("host"));
		prop.put("mail.smtp.user",prop.getProperty("from"));
		prop.put("mail.smtp.password",prop.getProperty("password"));
		prop.put("mail.smtp.port",prop.getProperty("port"));
		prop.put("mail.smtp.auth","true");

		System.out.println(prop.getProperty("from"));
		Session session=Session.getInstance(prop);
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress(prop.getProperty("from")));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(prop.getProperty("to")));
		message.setSubject("Report on testing");

		BodyPart body=new MimeBodyPart();
		body.setText("sending an extent report");

		//MimeBodyPart messagebody=new MimeBodyPart();
		MimeBodyPart messagebody=new MimeBodyPart();

		String html=System.getProperty("user.dir")+prop.getProperty("DEST")+Report.da+prop.getProperty("DEST2");
		DataSource source=new FileDataSource(html);

		messagebody.setDataHandler(new DataHandler(source));
		messagebody.setFileName(html);
		Multipart multipart=new MimeMultipart();

		multipart.addBodyPart(messagebody);
		message.setContent(multipart);

		Transport transport=session.getTransport("smtp");
		transport.connect(prop.getProperty("host"),prop.getProperty("from"),prop.getProperty("password"));
		transport.sendMessage(message, message.getAllRecipients());

		System.out.println("mail sent");

		transport.close();





	}

}
