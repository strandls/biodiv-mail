/**
 * 
 */
package com.strandls.mail;

import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;

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

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

		Injector injector = (Injector) servletContextEvent.getServletContext().getAttribute(Injector.class.getName());

		Channel channel = injector.getInstance(Channel.class);
		try {
			channel.getConnection().close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		super.contextDestroyed(servletContextEvent);
		// ... First close any background tasks which may be using the DB ...
		// ... Then close any DB connection pools ...

		// Now deregister JDBC drivers in this context's ClassLoader:
		// Get the webapp's ClassLoader
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		// Loop through all drivers
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			if (driver.getClass().getClassLoader() == cl) {
				// This driver was registered by the webapp's ClassLoader, so deregister it:
				try {
					logger.info("Deregistering JDBC driver {}", driver);
					DriverManager.deregisterDriver(driver);
				} catch (SQLException ex) {
					logger.error("Error deregistering JDBC driver {}", driver, ex);
				}
			} else {
				// driver was not registered by the webapp's ClassLoader and may be in use
				// elsewhere
				logger.trace("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader",
						driver);
			}
		}

	}

}
