package com.example.springsecurity.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtUtil {

    SecretKey key;

    public JwtUtil() {

        key = Keys.hmacShaKeyFor("/nctxZrIDSnatbXRnVRaf1OO+LOAiduMDjfgYEsAXRQ=".getBytes());
//        KeyGenerator keyGenerator;
//        try {
//            keyGenerator = KeyGenerator.getInstance("HmacSHA256");
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//        SecretKey secretKey = keyGenerator.generateKey();
//        byte[] encoded = secretKey.getEncoded();
//
//        String base64Key = Base64.getEncoder().encodeToString(encoded);
//        System.out.println("Raw Key Bytes (Base64): " + base64Key);
//
//        key = secretKey;
    }

    public String generateJWTToken(String userName) {

        Map<String, Objects> claims = new HashMap<>();
        String jwtToken = Jwts.builder()
                .claims()
                .add(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .and()
                .signWith(key)
                .compact();
        return jwtToken;
    }


    public String extractUsername(String token)
    {
        return extractClaims(token,Claims::getSubject);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private <T>T extractClaims(String token, Function<Claims,T> claimResolver)
    {
        final Claims claims=extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public boolean validateToken(String token, UserDetails userDetails)
    {
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token)
    {
        return extractExpireDate(token).before(new Date());
    }

    public Date extractExpireDate(String token)
    {
        return extractClaims(token,Claims::getExpiration);
    }
}