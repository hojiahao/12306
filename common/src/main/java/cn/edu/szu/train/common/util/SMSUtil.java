package cn.edu.szu.train.common.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author Mr.He
 * @version 1.0
 * @description: 短信工具类
 */

public class SMSUtil {
    /**
     * 发送短信
     *
     * @param signName 签名
     * @param templateCode 模板
     * @param phoneNumber 手机号
     * @param param 内容
     */
    public static void sendMessage(String signName, String templateCode, String phoneNumber, String param) {
        /*
         * 这三个需要自己填写
         * cn-shenzhen：服务地区，选择距离自己近的，我选择的是cn-hangzhou
         * AccessKey ID：访问阿里云 API 的Id
         * AccessKey Secret：Id对应的密钥，具有该账户相应的权限
         */
        DefaultProfile profile = DefaultProfile.getProfile("cn-shenzhen", "LTAI5tJ5WZHrQP99EU7tNyT3", "uvkYSvBRBIfB0W0ZEKrn085SjfRwfj");
        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.setSysRegionId("cn-shenzhen");
        sendSmsRequest.setPhoneNumbers(phoneNumber);
        sendSmsRequest.setSignName(signName);
        sendSmsRequest.setTemplateCode(templateCode);
        sendSmsRequest.setTemplateParam("{\"code\":\"" + param + "\"}");

        try {
            SendSmsResponse sendSmsResponse = client.getAcsResponse(sendSmsRequest);
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
    }
}
