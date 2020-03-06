/**
 * 
 */
package com.strandls.mail.controller;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author Abhishek Rudra
 *
 */
public class MailControllerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MailController.class).in(Scopes.SINGLETON);
	}
}
