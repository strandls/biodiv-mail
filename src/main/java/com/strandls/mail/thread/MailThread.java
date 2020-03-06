package com.strandls.mail.thread;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.strandls.mail.util.MailUtil;

public class MailThread extends MailUtil implements Runnable {
	
	public MailThread(String[] to, String[] bcc, String subject, String content, boolean isHTML) {
		super(to, bcc, subject, content, isHTML);
	}

	@Override
	public void run() {
		try {
			sendMail();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
