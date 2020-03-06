package com.strandls.mail.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.ObservationMailService;
import com.strandls.mail.service.UserMailService;
import com.strandls.mail.util.AppUtil;
import com.strandls.mail.util.AppUtil.MAIL_TYPE;
import com.strandls.mail.util.PropertyFileUtil;

public class RabbitMQConsumer {

	@Inject
	UserMailService userService;

	@Inject
	ObservationMailService observationService;

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@Inject
	private Channel channel;

	public void getMessage() throws Exception {
		DeliverCallback callback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			processMessage(message);
		};
		channel.basicConsume(PropertyFileUtil.fetchProperty("config.properties", "rabbitmq_queue"), true, callback,
				consumerTag -> {
				});
	}

	private void processMessage(String message) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			MailInfo info = mapper.readValue(message, MailInfo.class);

			MAIL_TYPE type = AppUtil.getMailType(info.getType());
			switch (type) {
			case RESET_PASSWORD:
				userService.sendResetPasswordMail(info);
				break;
			case USER_REGISTRATION:
				userService.sendActivationMail(info);
				break;
			case WELCOME_MAIL:
				userService.sendWelcomeMail(info);
				break;
			case DOWNLOAD_MAIL:
				observationService.sendObservationDownloadMail(info);
				break;
			case COMMENT_POST:
				observationService.sendObservationCommentedMail(info);
				break;
			case SUGGEST_MAIL:
				observationService.sendObservationSuggestedMail(info);
				break;
			case TAGGED_MAIL:
				observationService.sendObservationTaggedMail(info);
				break;
			case POST_TO_GROUP:
				observationService.sendObservationPostToGroupMail(info);
				break;
			default:
				logger.error("Invalid mail type: {}", info.getType());
			}
		} catch (Exception ex) {
			logger.error("Could not resolve: {}", message);
		}
	}

}
