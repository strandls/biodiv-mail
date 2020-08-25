package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.ObservationMailService;
import com.strandls.mail.util.ThreadUtil;

import freemarker.template.Configuration;

public class ObservationMailServiceImpl implements ObservationMailService {

	@Inject
	private Configuration configuration;

	@Override
	public void sendObservationPostToGroupMail(List<MailInfo> info) {
		String submitType = info.get(0).getData().get("submitType").toString();
		String subject;
		if (submitType.equalsIgnoreCase("post")) {
			subject = "Posted observation to group";
		} else {
			subject = "Removed observation from group";
		}
		ThreadUtil.startThread(configuration, "observation.ftlh", subject, info);
	}

	@Override
	public void sendObservationTaggedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Tagged in observation comment", info);
	}

	@Override
	public void sendObservationSuggestedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Species name suggested", info);
	}

	@Override
	public void sendObservationCommentedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "New comment in observation", info);
	}

	@Override
	public void sendObservationDownloadMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Download request", info);
	}
	
	@Override
	public void sendObservationFactAddedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Fact added", info);
	}

	@Override
	public void sendObservationFactUpdatedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Fact updated", info);
	}

	@Override
	public void sendObservationAgreedSpeciesMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Species name suggested", info);		
	}

	@Override
	public void sendObservationRemovedSpeciesMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Species name deleted", info);
	}

	@Override
	public void sendObservationCustomFieldUpdatedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Custom field edited", info);
	}

	@Override
	public void sendObservationFeaturedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Featured observation", info);
	}

	@Override
	public void sendObservationAddedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation added", info);	
	}

	@Override
	public void sendObservationFlaggedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation flagged", info);		
	}

	@Override
	public void sendObservationLockedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Validated and locked species name", info);		
	}

	@Override
	public void sendObservationUpdatedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation updated", info);
	}

	@Override
	public void sendObservationUnlockedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Unlocked species name", info);			
	}

	@Override
	public void sendObservationTagUpdatedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation tag updated", info);
	}

	@Override
	public void sendObservationDeletedMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation deleted", info);
	}

	@Override
	public void sendRatedMediaMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "observation.ftlh", "Observation media rated", info);		
	}
	
	@Override
	public void sendMyUploadsDeletionMail(List<MailInfo> info) {
		ThreadUtil.startThread(configuration, "deletion.ftlh", "Attn: Your image uploads are due for deletion", info);
	}

}
