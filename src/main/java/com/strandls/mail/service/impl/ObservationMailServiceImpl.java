package com.strandls.mail.service.impl;

import com.google.inject.Inject;
import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.ObservationMailService;
import com.strandls.mail.util.ThreadUtil;

import freemarker.template.Configuration;

public class ObservationMailServiceImpl implements ObservationMailService {

	@Inject
	private Configuration configuration;

	@Override
	public void sendObservationPostToGroupMail(MailInfo info) {
		String submitType = info.getData().get("submitType").toString();
		String subject;
		if (submitType.equalsIgnoreCase("post")) {
			subject = "Posted observation to group";
		} else {
			subject = "Removed observation from group";
		}
		ThreadUtil.startThread(configuration, "observation.ftlh", subject, info);
	}

	@Override
	public void sendObservationTaggedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Tagged in observation comment", info);
	}

	@Override
	public void sendObservationSuggestedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Species name suggested", info);
	}

	@Override
	public void sendObservationCommentedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "New comment in observation", info);
	}

	@Override
	public void sendObservationDownloadMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Download request", info);
	}

}
