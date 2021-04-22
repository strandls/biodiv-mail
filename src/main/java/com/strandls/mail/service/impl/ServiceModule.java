package com.strandls.mail.service.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.strandls.mail.service.ObservationMailService;
import com.strandls.mail.service.PermisisonMailService;
import com.strandls.mail.service.UserGroupService;
import com.strandls.mail.service.UserMailService;

public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(UserMailService.class).to(UserMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(ObservationMailService.class).to(ObservationMailServiceImpl.class).in(Scopes.SINGLETON);
		bind(UserGroupService.class).to(UserGroupServiceImpl.class).in(Scopes.SINGLETON);
		bind(PermisisonMailService.class).to(PermisisonMailServiceImpl.class).in(Scopes.SINGLETON);
	}

}
