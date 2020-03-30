package com.liangliang.community.api;

/**
 * @author Liangliang
 * @date 2020/3/30
 * @desc 封装API的错误码
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
