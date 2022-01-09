package com.item.common.logic;

import com.item.common.common.BaseContext;
import com.item.common.common.CommonException;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-14
 */

@Slf4j
public abstract class AbstractRequestLogic implements ExecLogic {
    @Override
    public void execLogic(BaseContext baseContext) throws CommonException {
      log.info("{} logic start.", this.getClass().getSimpleName());

      log.info("{} logic end.", this.getClass().getSimpleName());
    }
}
