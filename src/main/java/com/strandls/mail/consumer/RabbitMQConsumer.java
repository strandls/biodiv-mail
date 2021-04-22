package com.strandls.mail.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.strandls.mail.model.MailInfo;
import com.strandls.mail.model.NotificationInfo;
import com.strandls.mail.model.RecipientInfo;
import com.strandls.mail.service.ObservationMailService;
import com.strandls.mail.service.PermisisonMailService;
import com.strandls.mail.service.UserGroupService;
import com.strandls.mail.service.UserMailService;
import com.strandls.mail.util.NotificationUtil;
import com.strandls.mail.util.PropertyFileUtil;
import com.strandls.mail_utility.util.AppUtil;
import com.strandls.mail_utility.model.EnumModel.MAIL_TYPE;

public class RabbitMQConsumer {

	@Inject
	private UserMailService userService;

	@Inject
	private ObservationMailService observationService;

	@Inject
	private UserGroupService userGroupService;

	@Inject
	private PermisisonMailService permissionService;

	@Inject
	ObjectMapper mapper;

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@Inject
	private Channel channel;

	public void getMessage() throws Exception {
		DeliverCallback callback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			processMessage(message);
		};
		DeliverCallback notificationCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			processNotification(message);
		};
		channel.basicConsume(PropertyFileUtil.fetchProperty("config.properties", "rabbitmq_queue"), true, callback,
				consumerTag -> {
				});
		channel.basicConsume(PropertyFileUtil.fetchProperty("config.properties", "rabbitmq_n_queue"), true,
				notificationCallback, consumerTag -> {
				});
	}

	private void processMessage(String message) {
		try {
			System.out.println("***** Message: " + message + " *****");
			RecipientInfo recipient = mapper.readValue(message, RecipientInfo.class);
			List<MailInfo> info = new ArrayList<MailInfo>();
			if (recipient.getRecipients() != null) {
				recipient.getRecipients().forEach((r) -> {
					MailInfo m = mapper.convertValue(r, MailInfo.class);
					info.add(m);
				});
			}

			if (info.size() == 0) {
				logger.error("No recipients: {}", recipient.getRecipients());
				return;
			}

			MAIL_TYPE type = AppUtil.getMailType(recipient.getType());
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
			case FACT_ADDED:
				observationService.sendObservationFactAddedMail(info);
				break;
			case FACT_UPDATED:
				observationService.sendObservationFactUpdatedMail(info);
				break;
			case AGREED_SPECIES:
				observationService.sendObservationAgreedSpeciesMail(info);
				break;
			case REMOVED_SPECIES:
				observationService.sendObservationRemovedSpeciesMail(info);
				break;
			case CUSTOM_FIELD_UPDATED:
				observationService.sendObservationCustomFieldUpdatedMail(info);
				break;
			case FEATURED_POST:
				observationService.sendObservationFeaturedMail(info);
				break;
			case FEATURED_POST_IBP:
				observationService.sendObservationFeaturedMail(info);
				break;
			case OBSERVATION_ADDED:
				observationService.sendObservationAddedMail(info);
				break;
			case OBSERVATION_FLAGGED:
				observationService.sendObservationFlaggedMail(info);
				break;
			case OBSERVATION_LOCKED:
				observationService.sendObservationLockedMail(info);
				break;
			case OBSERVATION_UNLOCKED:
				observationService.sendObservationUnlockedMail(info);
				break;
			case OBSERVATION_UPDATED:
				observationService.sendObservationUpdatedMail(info);
				break;
			case OBSERVATION_DELETED:
				observationService.sendObservationDeletedMail(info);
				break;
			case RATED_MEDIA_RESOURCE:
				observationService.sendRatedMediaMail(info);
				break;
			case TAG_UPDATED:
				observationService.sendObservationTagUpdatedMail(info);
				break;
			case MY_UPLOADS_DELETE_MAIL:
				observationService.sendMyUploadsDeletionMail(info);
				break;
			case SEND_INVITE:
				userGroupService.sendInvites(info);
				break;
			case SEND_REQUEST:
				userGroupService.sendRequest(info);
				break;
			case PERMISSION_REQUEST:
				permissionService.sendPermissionRequest(info);
				break;
			case PERMISSION_GRANTED:
				permissionService.sendPermissionGranted(info);
				break;

			default:
				logger.error("Invalid mail type: {}", type);
			}
		} catch (Exception ex) {
			logger.error("Could not resolve: {}", ex.getMessage());
		}
	}

	private void processNotification(String message) {
		try {
			System.out.println("\n\n***** Notification Message: " + message + " *****\n\n");
			NotificationInfo info = mapper.readValue(message, NotificationInfo.class);
			if (info != null) {
				NotificationUtil notification = new NotificationUtil();
				notification.sendNotification(message);
			}
		} catch (Exception ex) {
			logger.error("Could not resolve: {}", ex.getMessage());
		}
	}

}
