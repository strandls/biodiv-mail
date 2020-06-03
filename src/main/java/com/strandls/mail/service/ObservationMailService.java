package com.strandls.mail.service;

import com.strandls.mail.model.MailInfo;

public interface ObservationMailService {
	
	void sendObservationPostToGroupMail(MailInfo info);
	void sendObservationTaggedMail(MailInfo info);
	void sendObservationSuggestedMail(MailInfo info);
	void sendObservationCommentedMail(MailInfo info);
	void sendObservationDownloadMail(MailInfo info);
	void sendObservationFactUpdatedMail(MailInfo info);
	void sendObservationAgreedSpeciesMail(MailInfo info);
	void sendObservationRemovedSpeciesMail(MailInfo info);
	void sendObservationCustomFieldUpdatedMail(MailInfo info);
	void sendObservationFeaturedMail(MailInfo info);
	void sendObservationAddedMail(MailInfo info);
	void sendObservationFlaggedMail(MailInfo info);
	void sendObservationLockedMail(MailInfo info);
	void sendObservationUpdatedMail(MailInfo info);
	void sendObservationUnlockedMail(MailInfo info);
	void sendObservationDeletedMail(MailInfo info);
	void sendRatedMediaMail(MailInfo info);
	void sendObservationTagUpdatedMail(MailInfo info);
	void sendMyUploadsDeletionMail(MailInfo info);

}
