package com.demo.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 2:40
 * Json Web Token工具类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class JwtUtils {

    private JwtUtils() {
    }

    /**
     * 签名
     */
    private static final String SIGNATURE = "spring_boot";
    /**
     * 有效期
     * 1天
     */
    private static final long EXPIRATION = 1000L * 60 * 60 * 24;
    /**
     * 用户ID
     */
    private static final String UID = "uid";

    /**
     * 生成Token
     *
     * @param uid 用户ID
     * @return Token
     */
    public static String createToken(String uid) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setIssuer("jwt")
                .setAudience("jwt")
                .setSubject("auth")
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                .claim(UID, uid)
                .compact();
    }

    /**
     * 校验Token
     *
     * @param token Token
     */
    public static void checkToken(String token) {
        Jwts.parser().setSigningKey(SIGNATURE).parseClaimsJws(token);
    }

    /**
     * 获取载荷
     *
     * @param token token
     * @return 荷载
     */
    public static Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SIGNATURE).parseClaimsJws(token).getBody();
    }

    /**
     * 获取用户ID
     *
     * @param token Token
     * @return UID
     */
    public static String getUid(String token) {
        return (String) getClaims(token).get(UID);
    }
}
