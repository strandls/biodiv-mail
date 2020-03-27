package com.strandls.mail.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	private String[] to;
	private String[] bcc;
	private String subject;
	private String text;
	private boolean isHtml;
	
	private final static String username;
	private final static String password;
	private final static String mailSenderEmail;
	private final static String smtpHost;
	private final static String smtpPort;

	static {
		Properties prop = PropertyFileUtil.fetchProperty("config.properties");
		username = prop.getProperty("mail_smtp_username");
		password = prop.getProperty("mail_smtp_password");
		mailSenderEmail = prop.getProperty("mail_sender_email");
		smtpHost = prop.getProperty("mail_smtp_host");
		smtpPort = prop.getProperty("mail_smtp_port");
	}
	
	public MailUtil() {}
	
	public MailUtil(String[] to, String[] bcc, String subject, String text, boolean isHtml) {
		this.to = to;
		this.bcc = bcc;
		this.subject = subject;
		this.text = text;
		this.isHtml = isHtml;
	}

	public void sendMail() throws MessagingException, AddressException {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", smtpHost);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug.auth", "true");
        props.setProperty( "mail.pop3.socketFactory.fallback", "false");
		
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		List<InternetAddress> address = new ArrayList<>();
		for (String recipient: to) {
			address.add(new InternetAddress(recipient));
		}
		List<InternetAddress> bccAddress = new ArrayList<>();
		for (String recipient: bcc) {
			bccAddress.add(new InternetAddress(recipient));
		}
		InternetAddress[] addresses = new InternetAddress[address.size()];
		InternetAddress[] bccAddresses = new InternetAddress[address.size()];
		message.setFrom(new InternetAddress(mailSenderEmail));
		message.addRecipients(Message.RecipientType.TO, address.toArray(addresses));
		if (bccAddress.size() > 0) {
			message.addRecipients(Message.RecipientType.BCC, bccAddress.toArray(bccAddresses));			
		}
		message.setSubject(subject);
		message.setContent(text, isHtml ? "text/html" : "text/plain");
		
		Transport.send(message);
	}

}
