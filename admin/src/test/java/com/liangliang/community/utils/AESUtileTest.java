package com.liangliang.community.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liangliang
 * @date 2020/4/22
 * @desc
 */
public class AESUtileTest {

    @Test
    public void encrypt() {
        String context = "哈哈，test，测试测试11，{\"name\":\"zs\",\"age\":18}";
        String encryptContext = AESUtile.encrypt(context);
        System.out.println("encryptContext:" + encryptContext);
        String decryptContext = AESUtile.decrypt(encryptContext);
        System.out.println("decryptContext:" + decryptContext);
    }
}