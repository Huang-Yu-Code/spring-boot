package demo.web.common.util;

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
     * 生成Token
     *
     * @param issuer     发行
     * @param audience   受众
     * @param signature  签名
     * @param subject    主题
     * @param expiration 有效期
     * @param uid        用户ID
     * @return Token
     */
    public static <T> String createToken(String issuer, String audience, String signature, String subject, long expiration,
                                         T uid) {
        return Jwts.builder()
                .setIssuer(issuer)
                .setAudience(audience)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, signature)
                .claim("uid", uid)
                .compact();
    }

    /**
     * 校验Token
     *
     * @param signature 签名
     * @param token     token
     */
    public static void checkToken(String signature, String token) {
        Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
    }

    /**
     * 获取载荷
     *
     * @param signature 签名
     * @param token     token
     * @return 荷载
     */
    public static Claims getClaims(String signature, String token) {
        return Jwts.parser().setSigningKey(signature).parseClaimsJws(token).getBody();
    }

    /**
     * 获取用户ID
     *
     * @param signature 签名
     * @param token     token
     * @return uid
     */
    public static String getUid(String signature, String token) {
        Object uid = getClaims(signature, token).get("uid");
        return (String) uid;
    }
}
