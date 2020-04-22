package com.liangliang.community.utils;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Liangliang
 * @date 2020/4/21
 * @desc
 */
public class RSAUtil {
    private static Logger logger = LoggerFactory.getLogger(RSAUtil.class);

    /**
     * 加密
     */
    public static String encrypt(String context, String publicKey) {
        String encryptContext = "";
        try {
            PublicKey pubKey = KeyFactory.getInstance("RSA").generatePublic(
                    new X509EncodedKeySpec(Base64.decodeBase64(publicKey.getBytes(Charsets.UTF_8))));
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            encryptContext = Base64.encodeBase64String(cipher.doFinal(context.getBytes(Charsets.UTF_8)));
        } catch (Exception e) {
            logger.info("RSA加密失败");
        }
        return encryptContext;
    }

    /**
     * 解密
     */
    public static String decrypt(String encryptContext, String privateKey) {
        String message = "";
        try {
            PrivateKey priKey = KeyFactory.getInstance("RSA").generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey.getBytes(Charsets.UTF_8))));
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            message = new String(cipher.doFinal(Base64.decodeBase64(encryptContext.getBytes(Charsets.UTF_8))));
        } catch (Exception e) {
            logger.info("RSA解密失败");
        }
        return message;
    }

    /**
     * 获取公钥、密钥  0：公钥  1：私钥
     */
    public static Map<Integer, String> getKeys() {
        Map<Integer, String> keyMap = new HashMap<>();
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            String publicKey = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
            String privateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
            keyMap.put(0, publicKey);
            keyMap.put(1, privateKey);
        } catch (NoSuchAlgorithmException e) {
            logger.info("生成公钥、密钥失败");
        }
        return keyMap;
    }
}
