package com.zzz.item.common;

import com.zzz.item.common.io.CommonRequest;
import com.zzz.item.common.io.CommonResponse;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.MapUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-14
 */

@Setter
@Getter
public class BaseContext extends ConcurrentHashMap<String, Object> {
    protected static final ThreadLocal<? extends BaseContext> threadLocal = new ThreadLocal<BaseContext>(){
        @Override
        protected BaseContext initialValue() {
        return new BaseContext();
        }
    };

    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;
    private byte[] rawRequest;
    private CommonRequest request;
    private CommonResponse response;
    private Map<String, Object> requestParams;
    private String commandId;
    private String timestamp;

    /**
     * 获取上下文
     *
     * @return BaseContext
     */
    public static BaseContext currentContext() {
        return threadLocal.get();
    }

    /**
     * 清空上下文
     */
    public static void clearContext() {
        threadLocal.remove();
    }

    /**
     * 获取请求参数
     *
     * @param paramName paramName
     * @return Optional
     */
    public Optional<Object> getRequestParam(String paramName) {
        if (MapUtils.isEmpty(requestParams)) {
            return Optional.empty();
        }
        return Optional.of(MapUtils.getString(requestParams, paramName));
    }

    /**
     * 参数放入上下文
     *
     * @param paramName paramName
     * @param param param
     */
    public void setParam(String paramName, Object param) {
        requestParams.put(paramName, param);
    }
}
