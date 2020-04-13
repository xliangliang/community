package com.liangliang.community.exception;

import com.liangliang.community.api.IErrorCode;

/**
 * @author Liangliang
 * @date 2020/4/13
 * @desc 断言处理类
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
