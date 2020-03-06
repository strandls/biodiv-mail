/**
 * 
 */
package com.strandls.mail;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Abhishek Rudra
 *
 */
public class RabbitMqConnection {

	public Channel setRabbitMQConnetion() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("ibp");
		factory.setPassword("ibp");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(ApiConstants.MAIL_EXCHANGE, "direct");
		channel.queueDeclare(ApiConstants.MAIL_QUEUE, false, false, false, null);
		channel.queueBind(ApiConstants.MAIL_QUEUE, ApiConstants.MAIL_EXCHANGE, ApiConstants.MAIL_ROUTING_KEY);
		return channel;
	}
}
