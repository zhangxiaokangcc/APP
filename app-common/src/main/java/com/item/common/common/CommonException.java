package com.item.common.common;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-14
 */

public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -532648123481164454L;

    private String errorCode;

    public CommonException(String errorCode) {
        this.errorCode = errorCode;
    }

    public CommonException(String errorCode, String errorMsg, Throwable throwable) {
        super(errorMsg, throwable);
        this.errorCode = errorCode;
    }

    public CommonException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode.code());
        this.errorCode = commonErrorCode.code();
    }

    public CommonException(CommonErrorCode commonErrorCode, Throwable throwable) {
        super(commonErrorCode.desc(), throwable);
        this.errorCode = commonErrorCode.code();
    }
}
