package com.strandls.mail.service.impl;

import javax.inject.Inject;

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

	@Override
	public void sendObservationFactUpdatedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Fact updated", info);
	}

	@Override
	public void sendObservationAgreedSpeciesMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Species name suggested", info);		
	}

	@Override
	public void sendObservationRemovedSpeciesMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Species name deleted", info);
	}

	@Override
	public void sendObservationCustomFieldUpdatedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Custom field edited", info);
	}

	@Override
	public void sendObservationFeaturedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Featured observation", info);
	}

	@Override
	public void sendObservationAddedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation added", info);	
	}

	@Override
	public void sendObservationFlaggedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation flagged", info);		
	}

	@Override
	public void sendObservationLockedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Validated and locked species name", info);		
	}

	@Override
	public void sendObservationUpdatedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation updated", info);
	}

	@Override
	public void sendObservationUnlockedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Unlocked species name", info);			
	}

	@Override
	public void sendObservationTagUpdatedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation tag updated", info);
	}

	@Override
	public void sendObservationDeletedMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation deleted", info);
	}

	@Override
	public void sendRatedMediaMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation media rated", info);		
	}
	
	@Override
	public void sendMyUploadsDeletionMail(MailInfo info) {
		ThreadUtil.startThread(configuration, "deletion.ftlh", "Attn: Your image uploads are due for deletion", info);
	}

}
