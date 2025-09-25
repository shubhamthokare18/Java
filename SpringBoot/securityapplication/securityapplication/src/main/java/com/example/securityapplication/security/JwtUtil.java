package com.example.securityapplication.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
    private final String secretKey="60f5ce4542a8086924736b55d6cf0c737c72a2859fef6d430018fe7ec4b0010b";
    public String extractUsername(String token)
    {
        return extractClaims(token, Claims::getSubject);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T>T extractClaims(String token, Function<Claims,T> claimResolver)
    {
        final Claims claims=extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails)
    {
        return
                Jwts
                        .builder()
                        .setClaims(extraClaims)
                        .setSubject(userDetails.getUsername())
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis()*1000*60*60*24))
                        .signWith(getSignInKey())
                        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                        .compact();
    }


    public String generateToken(UserDetails  userDetails)
    {
        return generateToken(new HashMap<>(),userDetails);
    }

    public boolean validateToken(String token,UserDetails userDetails)
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

    public Key getSignInKey()
    {
        byte[]keyBytes= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}