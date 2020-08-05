package com.strandls.mail.util;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.thread.MailThread;

import freemarker.template.Configuration;

public class ThreadUtil {

	public static void startThread(Configuration configuration, String templateFile, String mailSubject,
			MailInfo info) {
		TemplateUtil template = new TemplateUtil(configuration);
		String content = template.getTemplateAsString(templateFile, info.getData());
		String subject = info.getSubject();
		String bcc = PropertyFileUtil.fetchProperty("config.properties", "mail_bcc");
		if (info.getSubscription() != null && info.getSubscription()) {
			MailThread mail = new MailThread(info.getTo(), new String[] {},
					(subject == null || subject.isEmpty()) ? mailSubject : subject, content, true);
			Thread thread = new Thread(mail);
			thread.start();
		}

		// Admin Thread
		MailThread aMail = new MailThread(bcc.split(","), new String[] {},
				(subject == null || subject.isEmpty()) ? mailSubject : subject, content, true);
		Thread aThread = new Thread(aMail);
		aThread.start();
	}

}
