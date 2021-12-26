package com.item.common.common;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-14
 */

public enum CommonErrorCode implements EnumErrorCode {
    SUCCESS("0", "Success."),
    FAILED("-1", "system error."),
    ;

    private String errorCode;

    private String errorDesc;

    CommonErrorCode(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    @Override
    public String code() {
        return errorCode;
    }

    @Override
    public String desc() {
        return errorDesc;
    }
}
