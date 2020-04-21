package com.liangliang.community.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * @author Liangliang
 * @date 2020/4/21
 * @desc
 */
public class AESUtile {

    public static void main(String[] args) {
        try {
            KeyGenerator aes = KeyGenerator.getInstance("AES");
            aes.init(128);
            SecretKey secretKey = aes.generateKey();

            Cipher.getInstance("RSA");
            System.out.println(secretKey.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
