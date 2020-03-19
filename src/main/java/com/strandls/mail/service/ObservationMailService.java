package com.strandls.mail.service;

import com.strandls.mail.model.MailInfo;

public interface ObservationMailService {
	
	void sendObservationPostToGroupMail(MailInfo info);
	void sendObservationTaggedMail(MailInfo info);
	void sendObservationSuggestedMail(MailInfo info);
	void sendObservationCommentedMail(MailInfo info);
	void sendObservationDownloadMail(MailInfo info);
	void sendObservationFactUpdatedMail(MailInfo info);

}
