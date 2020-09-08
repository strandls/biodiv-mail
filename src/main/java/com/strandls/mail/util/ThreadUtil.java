package com.strandls.mail.util;

import java.util.Arrays;
import java.util.List;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.thread.MailThread;

import freemarker.template.Configuration;

public class ThreadUtil {

	public static void startThread(Configuration configuration, String templateFile, String mailSubject,
			List<MailInfo> recipients) {
		TemplateUtil template = new TemplateUtil(configuration);
		String subject = "";
		String content = "";
		if (recipients != null) {
			for (MailInfo info : recipients) {
				content = template.getTemplateAsString(templateFile, info.getData());
				subject = info.getSubject();
				boolean containsIBP = Arrays.asList(info.getTo()).stream().anyMatch(id -> {
					return id.contains("ibp.org");
				});
				if (info.getSubscription() != null && info.getSubscription() && !containsIBP) {
					MailThread mail = new MailThread(info.getTo(), new String[] {},
							(subject == null || subject.isEmpty()) ? mailSubject : subject, content, true);
					Thread thread = new Thread(mail);
					thread.start();
				}
			}
		}

		// Admin Thread
		String bcc = PropertyFileUtil.fetchProperty("config.properties", "mail_bcc");
		MailThread aMail = new MailThread(bcc.split(","), new String[] {},
				(subject == null || subject.isEmpty()) ? mailSubject : subject, content, true);
		Thread aThread = new Thread(aMail);
		aThread.start();
	}

}
