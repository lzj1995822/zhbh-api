package com.jtzh.jpush;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.DefaultResult;
import cn.jpush.api.JPushClient;
import cn.jpush.api.device.TagAliasResult;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JpushUtils {
	protected static final Logger LOG = LoggerFactory.getLogger(Push.class);

	protected static final String APP_KEY = "0e1118c684678ee5d7d31984";

	protected static final String MASTER_SECRET = "9fdb8aadbfefd971fdb6530c";

	public static void sendMsgToAndroid(String content, String alias1) {
		ClientConfig clientConfig = ClientConfig.getInstance();
		JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
		PushPayload payload = buildPushObject_android(alias1, content);
		try {
			PushResult localPushResult = jpushClient.sendPush(payload);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
			LOG.error("Sendno: " + payload.getSendno());
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
			LOG.error("Sendno: " + payload.getSendno());
		}
	}

	public static PushPayload buildPushObject_android(String alias1, String content) {
		return

		PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.alias(alias1))
				.setNotification(Notification.android(content, "派发通知", null)).build();
	}

	@Test
	public void testSendWithSMS() {
		JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
		try {
			jpushClient.sendNotificationAll("hello world");
			jpushClient.sendMessageAll("this is a message");
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}
}
