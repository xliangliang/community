package com.liangliang.community.utils;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author Liangliang
 * @date 2020/4/21
 * @desc
 */
public class AESUtile {
    private static Logger logger = LoggerFactory.getLogger(AESUtile.class);
    private static final String SEED = "liangliang";
    private static SecretKey secretKey;

    static {
        try {
            // AES密钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(SEED.getBytes()));
            secretKey = keyGenerator.generateKey();
            logger.info("secretKey:{}", secretKey);
        } catch (NoSuchAlgorithmException e) {
            logger.info("AES密钥初始化失败");
        }
    }

    /**
     * 加密
     */
    public static String encrypt(String context) {
        String encryptContext = "";
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptContext = Base64.encodeBase64String(cipher.doFinal(context.getBytes(Charsets.UTF_8)));
        } catch (Exception e) {
            logger.info("AES加密失败");
        }
        return encryptContext;
    }

    /**
     * 解密
     */
    public static String decrypt(String encryptContext) {
        String context = "";
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            context = new String(cipher.doFinal(Base64.decodeBase64(encryptContext.getBytes(Charsets.UTF_8))));
        } catch (Exception e) {
            logger.info("AES解密失败");
        }
        return context;
    }
}
