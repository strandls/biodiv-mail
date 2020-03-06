package com.strandls.mail.model;

import java.util.Arrays;
import java.util.Map;

public class MailInfo {
	
	private String type;
	private String subject;
	private Map<String, Object> data;
	private String[] to;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "MailInfo [type=" + type + ", subject=" + subject + ", data=" + data + ", to=" + Arrays.toString(to)
				+ "]";
	}

}
