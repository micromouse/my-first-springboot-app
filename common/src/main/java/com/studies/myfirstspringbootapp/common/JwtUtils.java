package com.studies.myfirstspringbootapp.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * Jwt工具
 */
@Slf4j
public class JwtUtils {
    private final static String signKey = "this is a sign key";
    private final static long expire = 3600 * 1000;

    /**
     * 生成jwt token
     *
     * @param claims ：自定义内容
     * @return ：jwt token
     */
    public static String generate(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .addClaims(claims)
                .compact();
    }

    /**
     * 解析jwt token
     *
     * @param jwt ：jwt token
     * @return ：自定义内容
     */
    public static Claims parse(String jwt) {
        //jwt值不能为null
        if (!StringUtils.hasLength(jwt)) {
            throw new IllegalArgumentException("jwt值不能为空");
        }

        //解析
        return Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    /**
     * 无异常解析jwt token
     *
     * @param jwt ：jwt token
     * @return ：jwt中自定义内容
     */
    public static Optional<Claims> tryParse(String jwt) {
        try {
            return StringUtils.hasLength(jwt) ? Optional.of(parse(jwt)) : Optional.empty();
        } catch (Exception ex) {
            log.error("解析JWT时发生异常:{}", ex.getMessage(), ex);
            return Optional.empty();
        }
    }

}
