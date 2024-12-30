package cn.edu.szu.train.common.util;

import cn.hutool.core.util.IdUtil;

public class SnowUtil {
    private static final long datacenterId = 1L;    // datacenter
    private static final long workerId = 1L;    // machine identifier

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, datacenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, datacenterId).nextIdStr();
    }
}
