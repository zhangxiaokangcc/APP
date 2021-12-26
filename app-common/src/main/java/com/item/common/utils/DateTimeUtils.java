package com.item.common.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-13
 */

public class DateTimeUtils {
    private static final String dateFormat1 = "yyyy-MM-dd HH:mm:ss";
    private static final String dateFormat2 = "yyyy-MM-dd";
    private static final String dateFormat3 = "yyyy/MM/dd";

    /**
     * 获取当前时间戳
     *
     * @return Timestamp
     */
    public static Timestamp nowDateTime() {
        return Timestamp.valueOf(LocalDateTime.now());
    }

    public static Timestamp str2Timestamp(String str) {
        return Timestamp.valueOf(str);
    }

}
