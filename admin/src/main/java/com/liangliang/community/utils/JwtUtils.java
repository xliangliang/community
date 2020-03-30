package com.liangliang.community.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtUtils {

    /**
     * 过期时间15min
     */
    private final static long EXPIRE_TIME = 15 * 60 * 1000;
    /**
     * token私钥
     */
    private final static String TOKEN_SRECRET = "61e4a3430ca6a89527c7406363937f10";

    /**
     * 生成签名，15min后过期
     * @param username
     * @param userId
     * @return 加密后的token
     */
    public static String sign(String username, String userId) {
        try {
            // 设置过期时间
            Date expireTime = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SRECRET);
            // 设置头部信息
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("typ","JWT");
            map.put("alg","HS256");
            return JWT.create()
                    .withHeader(map)
                    .withClaim("loginName",username)
                    .withClaim("userId",userId)
                    .withExpiresAt(expireTime)
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验token是否正确
     * @param token
     * @return 正确：true
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SRECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Date expireTime = jwt.getExpiresAt();
            if (expireTime != null && new Date().after(expireTime)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Map getUserInfoByToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SRECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            return claims;
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
