package com.liangliang.community.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

    /**
     * 16进制
     */
    private static String[] chars = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * 将普通字符串用md5j加密，并转化为16j进制字符串
     * @param str
     * @return
     */
    public static String md5(String str) {

        // 消息签名
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
            byte[] result = md5.digest(str.getBytes());

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                byte b = result[i];
                // 取高位
                int h = 0x0f & (b >> 4);
                //取低位
                int l = 0x0f & b;
                sb.append(chars[h]).append(chars[l]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
