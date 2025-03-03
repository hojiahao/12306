package cn.edu.szu.train.common.util;

import java.util.Random;

/**
 * @author Mr.He
 * @version 1.0
 * @description 验证码工具类
 */
public class ValidateCodeUtil {
    /**
     * 随机生成验证码
     * @param length 长度为4位或者6位
     * @return code
     */
    public static Integer generateValidateCode(int length){
        Integer code = null;
        if(length == 4) {
            code = new Random().nextInt(9999);  //生成随机数，最大为9999
            if(code < 1000) {
                code += 1000;   //保证随机数为4位数字
            }
        }
        else if(length == 6) {
            code = new Random().nextInt(999999);    //生成随机数，最大为999999
            if(code < 100000) {
                code += 100000; //保证随机数为6位数字
            }
        }
        else {
            throw new RuntimeException("只能生成4位或6位数字验证码");
        }
        return code;
    }
}
