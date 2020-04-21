package com.liangliang.community.utils;

import javax.crypto.KeyGenerator;
import java.util.Base64;

/**
 * @author Liangliang
 * @date 2020/4/21
 * @desc
 */
public class ARUtil {

    // 解码
    private static Base64.Decoder decoder = Base64.getDecoder();
    // 加密
    private static Base64.Encoder encoder = Base64.getEncoder();

    public static void main(String[] args) {
        try {
            KeyGenerator.getInstance("AES");
        } catch (Exception e) {
            System.out.println("失败");
        }
    }
}
