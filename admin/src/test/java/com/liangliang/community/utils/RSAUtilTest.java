package com.liangliang.community.utils;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Liangliang
 * @date 2020/4/22
 * @desc
 */
public class RSAUtilTest {

    @Test
    public void encrypt() {
        Map<Integer, String> keyMap = RSAUtil.getKeys();
        String publicKey = keyMap.get(0);
        String privateKey = keyMap.get(1);
        System.out.println("publicKey:" + publicKey);
        System.out.println("privateKey:" + privateKey);

        String context = "哈哈，test RSA，测试测试RSA，{\"name\":\"RSA\",\"age\":18}";
        String encryptContext = RSAUtil.encrypt(context, publicKey);
        System.out.println("encryptContext:" + encryptContext);
        System.out.println("context:" + RSAUtil.decrypt(encryptContext, privateKey));
    }
}