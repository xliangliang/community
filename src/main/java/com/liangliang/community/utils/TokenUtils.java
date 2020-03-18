package com.liangliang.community.utils;

import java.util.UUID;

public class TokenUtils {

    public static String getToken(Long id) {
        String token = String.valueOf(id) + System.currentTimeMillis() + UUID.randomUUID().toString();
        return Md5Utils.md5(token);
    }
}
