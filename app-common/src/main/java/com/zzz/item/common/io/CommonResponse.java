package com.zzz.item.common.io;

import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-13
 */

@Setter
@Getter
public class CommonResponse {
    private String responseCode = "0";

    private String responseMsg = "Accept Service success.";

    private Timestamp responseTime = Timestamp.valueOf(LocalDateTime.now());

    private JSONObject extendData;
}
