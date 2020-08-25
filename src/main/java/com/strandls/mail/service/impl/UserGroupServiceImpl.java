package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.UserGroupService;
import com.strandls.mail.util.ThreadUtil;

import freemarker.template.Configuration;

public class UserGroupServiceImpl implements UserGroupService {

	@Inject
	private Configuration configuration;

	@Override
	public void sendInvites(List<MailInfo> info) {
		try {
			String role = info.get(0).getData().get("role").toString();
			ThreadUtil.startThread(configuration, "invite.ftlh", "Invitation to join as " + role + " for group", info);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void sendRequest(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "request.ftlh", "Request to join as a member in group", info);
	}

}
