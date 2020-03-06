/**
 * 
 */
package com.strandls.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.rabbitmq.client.Channel;
import com.strandls.mail.consumer.RabbitMQConsumer;
import com.strandls.mail.consumer.RabbitMQConsumerModule;
import com.strandls.mail.controller.MailControllerModule;
import com.strandls.mail.service.impl.ServiceModule;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * @author Abhishek Rudra
 *
 */
public class MailServeletContextListener extends GuiceServletContextListener {
	
	private static final Logger logger = LoggerFactory.getLogger(MailServeletContextListener.class);

	@Override
	protected Injector getInjector() {

		Injector injector = Guice.createInjector(new JerseyServletModule() {
			@Override
			protected void configureServlets() {

				ObjectMapper objectMapper = new ObjectMapper();
				bind(ObjectMapper.class).toInstance(objectMapper);// Rabbit MQ initialization
				
				RabbitMqConnection rabbitConnetion = new RabbitMqConnection();
				Channel channel = null;
				try {
					channel = rabbitConnetion.setRabbitMQConnetion();
				} catch (Exception e) {
					logger.error(e.getMessage());
				}

				bind(Channel.class).toInstance(channel);

				serve("/api/*").with(GuiceContainer.class);
			}
		}, new MailControllerModule(), new RabbitMQConsumerModule(), new ServiceModule());
		
		try {
			injector.getInstance(RabbitMQConsumer.class).getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return injector;

	}

}
