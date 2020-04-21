package com.liangliang.community.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author Liangliang
 * @date 2020/4/21
 * @desc
 */
public class RSAUtil {

    private static String publicKey;
    private static String privateKey;

    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
            publicKey = new String(Base64.encodeBase64(rsaPublicKey.getEncoded()));
            privateKey = new String(Base64.encodeBase64(rsaPrivateKey.getEncoded()));

            System.out.println("publicKey:" + publicKey);
            System.out.println("privateKey:" + privateKey);

            String eMsg = encrypt("亮亮好呀", publicKey);
            System.out.println("eMsg:" + eMsg);
            String message = decrypt(eMsg, privateKey);
            System.out.println("message:" + message);
        } catch (Exception e) {
            System.out.println("失败");
        }
    }

    private static String encrypt(String message, String pKey) {
        String encryptMsg = "";
        try {
            byte[] decodes = Base64.decodeBase64(pKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decodes));
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            encryptMsg = Base64.encodeBase64String(cipher.doFinal(message.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("加密失败");
        }
        return encryptMsg;
    }

    public static String decrypt(String encryptMsg, String priKey) {
        String message = "";
        try {
            byte[] msg = Base64.decodeBase64(encryptMsg.getBytes("UTF-8"));
            byte[] decoded = Base64.decodeBase64(priKey);
            RSAPrivateKey prKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, prKey);
            message = new String(cipher.doFinal(msg));
        } catch (Exception e) {
            System.out.println("解密失败");
        }
        return message;
    }
}
