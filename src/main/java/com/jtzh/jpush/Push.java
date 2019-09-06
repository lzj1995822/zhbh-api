     package com.jtzh.jpush;
     
     import cn.jiguang.common.ClientConfig;
     import cn.jiguang.common.resp.APIConnectionException;
     import cn.jiguang.common.resp.APIRequestException;
     import cn.jpush.api.JPushClient;
     import cn.jpush.api.push.PushResult;
     import cn.jpush.api.push.model.Platform;
     import cn.jpush.api.push.model.PushPayload;
     import cn.jpush.api.push.model.audience.Audience;
     import cn.jpush.api.push.model.notification.Notification;
     import org.slf4j.Logger;
     import org.slf4j.LoggerFactory;
     import org.springframework.stereotype.Component;

     @Component
     public class Push
     {
     protected static final Logger LOG = LoggerFactory.getLogger(Push.class);
       
       protected static final String APP_KEY = "89b8c81476d5d16c2b829550";
       
       protected static final String MASTER_SECRET = "a3de901b6b40cc23d07f713e";
       
       public static void sendMsgToAndroid(String content, String userid)
       {
       ClientConfig clientConfig = ClientConfig.getInstance();
       JPushClient jpushClient = new JPushClient("a3de901b6b40cc23d07f713e", "89b8c81476d5d16c2b829550", null, clientConfig);
       PushPayload payload = buildPushObject_android(userid, content);
         try {
         PushResult localPushResult = jpushClient.sendPush(payload);
         } catch (APIConnectionException e) {
         LOG.error("Connection error. Should retry later. ", e);
         LOG.error("Sendno: " + payload.getSendno());
         }
         catch (APIRequestException e) {
         LOG.error("Error response from JPush server. Should review and fix it. ", e);
        LOG.info("HTTP Status: " + e.getStatus());
         LOG.info("Error Code: " + e.getErrorCode());
       LOG.info("Error Message: " + e.getErrorMessage());
        LOG.info("Msg ID: " + e.getMsgId());
        LOG.error("Sendno: " + payload.getSendno());
         }
       }
       
       public static PushPayload buildPushObject_android(String userid, String content)
       {
      return 
         
     
     
         PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.alias(new String[] { userid })).setNotification(Notification.android(content, "茅山综治", null)).build();
       }
     }
