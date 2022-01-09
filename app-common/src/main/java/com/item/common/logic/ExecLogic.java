package com.item.common.logic;

import com.item.common.common.BaseContext;
import com.item.common.common.CommonException;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-14
 */

public interface ExecLogic {
    void execLogic(BaseContext baseContext) throws CommonException;
}
