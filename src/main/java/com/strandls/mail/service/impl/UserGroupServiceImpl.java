package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.UserGroupService;
import com.strandls.mail.util.ThreadUtil;

public class UserGroupServiceImpl implements UserGroupService {

	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendInvites(List<MailInfo> info) {
		try {
			String role = info.get(0).getData().get("role").toString();
			threadUtil.startThread("invite.ftlh", "Invitation to join as " + role + " for group", info);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void sendRequest(List<MailInfo> info) {
		threadUtil.startThread("request.ftlh", "Request to join as a member in group", info);
	}

}
