package com.example.common.util;

import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 项目: template
 * 时间: 2022/3/31 23:31
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Component
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "token")
@Getter
@Setter
public class TokenUtils {
    private final HttpServletRequest request;
    private String signature;
    private long expiration;

    /**
     * @param id       ID
     * @param username username
     * @return token
     */
    public String create(long id, String username) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, signature)
                .claim("id", id)
                .claim("username", username)
                .compact();
    }

    /**
     * 获取载荷
     *
     * @param token token
     * @return 荷载
     */
    public Claims getClaims(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
            return claimsJws.getBody();
        } catch (IllegalArgumentException e) {
            throw new CommonException(StatusCode.TOKEN_NULL);
        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            throw new CommonException(StatusCode.TOKEN_ERROR);
        } catch (ExpiredJwtException e) {
            throw new CommonException(StatusCode.TOKEN_EXPIRED);
        } catch (Exception e) {
            throw new CommonException(StatusCode.SERVER_EXCEPTION);
        }
    }

    /**
     * 获取用户ID
     *
     * @param token token
     * @return id
     */
    public Long getId(String token) {
        return getClaims(token).get("id", Long.class);
    }

    /**
     * 获取用户ID
     *
     * @return id
     */
    public Long getId() {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        return getId(token);
    }

    /**
     * 获取用户账号
     *
     * @param token token
     * @return username
     */
    public String getUsername(String token) {
        return getClaims(token).get("username", String.class);
    }

    /**
     * 获取用户账号
     *
     * @return username
     */
    public String getUsername() {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        return getUsername(token);
    }
}
