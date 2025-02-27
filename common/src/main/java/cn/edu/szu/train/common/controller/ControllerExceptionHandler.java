package cn.edu.szu.train.common.controller;

import cn.edu.szu.train.common.exception.BusinessException;
import cn.edu.szu.train.common.response.CommonResponse;
import cn.hutool.core.util.StrUtil;
//import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 所有异常统一处理
     * @param e: Exception
     * @return commonResp
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse<Object> exceptionHandler(Exception e) throws Exception {
//        LOG.info("seata全局事务ID save: {}", RootContext.getXID());
        // 如果是在一次全局事务里出现异常，就不要包装返回值，直接将异常抛给调用方，让调用方回滚事务。
//        if (StrUtil.isNotBlank(RootContext.getXID())) {
//            throw e;
//        }
        CommonResponse<Object> commonResponse = new CommonResponse<>();
        LOG.error("System Exception：", e);
        commonResponse.setSuccess(false);
        commonResponse.setMessage("The system is abnormal, please contact the administrator.");
        return commonResponse;
    }

    /**
     * 业务异常统一处理
     * @param e: BusinessException
     * @return commonResp
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResponse<Object> exceptionHandler(BusinessException e) {
        CommonResponse<Object> commonResponse = new CommonResponse<>();
        LOG.error("Business Exception：{}", e.getE().getDesc());
        commonResponse.setSuccess(false);
        commonResponse.setMessage(e.getE().getDesc());
        return commonResponse;
    }

    /**
     * 校验异常统一处理
     * @param e: BindException
     * @return commonResp
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResponse<Object> exceptionHandler(BindException e) {
        CommonResponse<Object> commonResponse = new CommonResponse<>();
        LOG.error("Validation Exception：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResponse.setSuccess(false);
        commonResponse.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResponse;
    }
}
