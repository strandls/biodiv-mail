package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.UserMailService;
import com.strandls.mail.util.ThreadUtil;

import freemarker.template.Configuration;

public class UserMailServiceImpl implements UserMailService {

	@Inject
	private Configuration configuration;

	@Override
	public void sendActivationMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "auth.ftlh", "Activate your account with India Biodiversity Portal", info);
	}

	@Override
	public void sendWelcomeMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "welcome.ftlh", "Welcome to India Biodiversity Portal", info);
	}

	@Override
	public void sendResetPasswordMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "auth.ftlh", "Reset password with India Biodiversity Portal", info);
	}

}
