package com.strandls.mail.service;

import com.strandls.mail.model.MailInfo;

public interface UserGroupService {
	
	public void sendInvites(MailInfo info);
	public void sendRequest(MailInfo info);

}
