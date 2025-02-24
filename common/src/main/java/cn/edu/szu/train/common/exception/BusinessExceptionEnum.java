package cn.edu.szu.train.common.exception;

public enum BusinessExceptionEnum {

    MEMBER_MOBILE_EXIST("Mobile phone number has been registered."),
    MEMBER_MOBILE_NOT_EXIST("Please obtain SMS verification code first."),
    MEMBER_MOBILE_CODE_ERROR("SMS verification code error."),

    BUSINESS_STATION_NAME_UNIQUE_ERROR("Station already exists, please re-enter."),
    BUSINESS_TRAIN_CODE_UNIQUE_ERROR("Train already exists, please re-enter."),
    BUSINESS_TRAIN_STATION_INDEX_UNIQUE_ERROR("Station number of the same train already exists, please re-enter."),
    BUSINESS_TRAIN_STATION_NAME_UNIQUE_ERROR("Station name of the same train already exists, please re-enter."),
    BUSINESS_TRAIN_CARRIAGE_INDEX_UNIQUE_ERROR("Cabin number of the same train already exists, please re-enter."),

    CONFIRM_ORDER_TICKET_COUNT_ERROR("余票不足"),
    CONFIRM_ORDER_EXCEPTION("服务器忙，请稍候重试"),
    CONFIRM_ORDER_LOCK_FAIL("当前抢票人数过多，请稍候重试"),
    CONFIRM_ORDER_FLOW_EXCEPTION("当前抢票人数太多了，请稍候重试"),
    CONFIRM_ORDER_SK_TOKEN_FAIL("当前抢票人数过多，请5秒后重试");

    private String desc;

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BusinessExceptionEnum{" +
                "desc='" + desc + '\'' +
                "} " + super.toString();
    }
}
