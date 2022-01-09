package com.item.gateway.filter.pre;

import com.item.gateway.filter.AbstractZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2022-01-05
 */

@Slf4j
public class SessionPreFilter extends AbstractZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return Boolean.TRUE;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("start filter session...");
        return null;
    }
}
