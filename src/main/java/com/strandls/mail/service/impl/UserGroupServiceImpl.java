package com.strandls.mail.service.impl;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.UserGroupService;
import com.strandls.mail.util.ThreadUtil;

import freemarker.template.Configuration;

public class UserGroupServiceImpl implements UserGroupService {

	@Inject
	private Configuration configuration;

	@Override
	public void sendInvites(MailInfo info) {
		try {
			String role = info.getData().get("role").toString();
			ThreadUtil.startThread(configuration, "invite.ftlh", "Invitation to join as " + role + " for group", info);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void sendRequest(MailInfo info) {
		ThreadUtil.startThread(configuration, "invite.ftlh", "Request to join as a member in group", info);
	}

}
