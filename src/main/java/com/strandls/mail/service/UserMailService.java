package com.strandls.mail.service;

import com.strandls.mail.model.MailInfo;

public interface UserMailService {
	
	void sendActivationMail(MailInfo info);
	void sendWelcomeMail(MailInfo info);
	void sendResetPasswordMail(MailInfo info);

}
