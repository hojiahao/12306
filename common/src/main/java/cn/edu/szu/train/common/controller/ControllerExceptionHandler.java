package cn.edu.szu.train.common.controller;

import cn.edu.szu.train.common.exception.BusinessException;
import cn.edu.szu.train.common.response.CommonResp;
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
    public CommonResp<Object> exceptionHandler(Exception e) {
        CommonResp<Object> commonResp = new CommonResp<>();
        LOG.error("System Exception：", e);
        commonResp.setSuccess(false);
        commonResp.setMessage("The system is abnormal, please contact the administrator.");
        return commonResp;
    }

    /**
     * 业务异常统一处理
     * @param e: BusinessException
     * @return commonResp
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp<Object> exceptionHandler(BusinessException e) {
        CommonResp<Object> commonResp = new CommonResp<>();
        LOG.error("Business Exception：{}", e.getE().getDesc());
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getE().getDesc());
        return commonResp;
    }

    /**
     * 校验异常统一处理
     * @param e: BindException
     * @return commonResp
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp<Object> exceptionHandler(BindException e) {
        CommonResp<Object> commonResp = new CommonResp<>();
        LOG.error("Validation Exception：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResp;
    }

}
