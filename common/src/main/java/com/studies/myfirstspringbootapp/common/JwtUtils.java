package com.studies.myfirstspringbootapp.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * Jwt工具
 */
public class JwtUtils {
    private final static String signKey = "this is a sign key";
    private final static long expire = 3600 * 1000;

    /**
     * 生成jwt token
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
     * @param jwt ：jwt token
     * @return ：自定义内容
     */
    public  static Claims parse(String jwt){
        return Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

}
