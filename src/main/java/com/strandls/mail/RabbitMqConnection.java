/**
 * 
 */
package com.strandls.mail;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.strandls.mail.util.PropertyFileUtil;

/**
 * @author Abhishek Rudra
 *
 */
public class RabbitMqConnection {

	private static final String EXCHANGE;
	private static final String QUEUE;
	private static final String ROUTING_KEY;
	private static final String HOST;
	private static final Integer PORT;
	private static final String USERNAME;
	private static final String PASSWORD;

	static {
		Properties props = PropertyFileUtil.fetchProperty("config.properties");
		EXCHANGE = PropertyFileUtil.fetchProperty("config", props.getProperty("rabbitmq_exchange"));
		QUEUE = PropertyFileUtil.fetchProperty("config", props.getProperty("rabbitmq_queue"));
		ROUTING_KEY = PropertyFileUtil.fetchProperty("config", props.getProperty("rabbitmq_routingKey"));
		HOST = PropertyFileUtil.fetchProperty("config", props.getProperty("rabbitmq_host"));
		PORT = Integer.parseInt(PropertyFileUtil.fetchProperty("config", props.getProperty("rabbitmq_host")));
		USERNAME = PropertyFileUtil.fetchProperty("config", props.getProperty("rabbitmq_username"));
		PASSWORD = PropertyFileUtil.fetchProperty("config", props.getProperty("rabbitmq_password"));
	}

	public Channel setRabbitMQConnetion() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setPort(PORT);
		factory.setUsername(USERNAME);
		factory.setPassword(PASSWORD);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE, "direct");
		channel.queueDeclare(QUEUE, false, false, false, null);
		channel.queueBind(QUEUE, EXCHANGE, ROUTING_KEY);
		return channel;
	}
}
