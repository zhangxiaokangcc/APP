package com.item.common.rpc;

import com.item.common.common.io.CommonResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-13
 */

@Setter
@Getter
@ToString
public class RPCResponse<T> extends CommonResponse {

    private T data;

    public boolean isSuccess() {
        return StringUtils.equals("0", this.getResponseCode());
    }
}
