package com.item.gateway.filter;

import com.item.common.common.BaseContext;
import com.item.common.common.io.CommonResponse;
import com.item.common.utils.DateTimeUtils;
import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2022-01-05
 */

@Slf4j
public abstract class AbstractZuulFilter extends ZuulFilter {
    /**
     *
     * @param errorCode errorCode
     * @param errorDesc errorDesc
     */
    protected void buildResponse(String errorCode, String errorDesc) {
        BaseContext baseContext = new BaseContext();
        CommonResponse response = baseContext.getResponse();
        response.setResponseCode(errorCode);
        response.setResponseMsg(errorDesc);
        response.setResponseTime(DateTimeUtils.nowDateTime());
    }
}
