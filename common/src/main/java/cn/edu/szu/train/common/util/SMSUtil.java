package cn.edu.szu.train.common.util;


import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.aliyun.teautil.Common.assertAsString;

/**
 * @author Mr.He
 * @version 1.0
 * @description: 短信工具类
 */

public class SMSUtil {

    private static final Logger LOG = LoggerFactory.getLogger(SMSUtil.class);

    /**
     * <b>发送短信</b> :
     * <p>使用AK&amp;SK初始化账号Client</p>
     * @return Client
     *
     * @throws Exception
     */
    public static Client createClient() throws Exception {
        Config config = new Config();
        config.setAccessKeyId("LTAI5tJ5WZHrQP99EU7tNyT3");
        config.setAccessKeySecret("uvkYSvBRBIfB0W0ZEKrn085SjfRwfj");
        config.setRegionId("cn-shenzhen");
        return new Client(config);
    }

    public static void sendMessage(String signName, String templateCode, String phoneNumber, String param) throws Exception {
        Client client = SMSUtil.createClient();
        SendSmsRequest request = new SendSmsRequest()
                .setPhoneNumbers(phoneNumber)
                .setSignName(signName)
                .setTemplateCode(templateCode).setTemplateParam("{\"code\":\"" + param + "\"}");

        try {
            // 发送短信
            SendSmsResponse response = client.sendSmsWithOptions(request, new RuntimeOptions());

            // 打印返回结果
            LOG.info("Send SMS Response: {}", response.getBody().getCode());
            LOG.info("Send SMS Response Message: {}", response.getBody().getMessage());
        } catch (TeaException error) {
            // 处理 TeaException 错误
            LOG.info("Error Message: {}", error.getMessage());
            LOG.info("Error Recommend: {}", error.getData().get("Recommend"));
            assertAsString(error.message);
        } catch (Exception e) {
            // 处理其他异常
            TeaException error = new TeaException(e.getMessage(), e);
            LOG.info("Error Message: {}", error.getMessage());
            LOG.info("Error Recommend: {}", error.getData().get("Recommend"));
            assertAsString(error.message);
        }
    }
}
