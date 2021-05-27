package io.lemon.cloud.common.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static final long DEFAULT_TOKEN_EXPIRE_TIME = 2 * 60 * 60 * 1000;

    private static final String DEFAULT_SECRET = "UnionPay2020";

    public static String generateToken(String userId) {
        Map<String, Object> claims = new HashMap<>(3);
        claims.put(Claims.SUBJECT, userId);
        Date expirationDate = new Date(System.currentTimeMillis() + DEFAULT_TOKEN_EXPIRE_TIME);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, DEFAULT_SECRET)
                .compact();
    }



}
