package com.example.spring_security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;

@Service
public class JwtUtils {

   private String SECRET_KEY = "secret_key";
   private long sessionTime = 120000000;

   private Claims extractAllClaims(String token) {
      return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
   }

   private String createToken(Map<String, Object> claims, String subject){
      return Jwts.builder()
              .setClaims(claims)
              .setSubject(subject)
              .setIssuedAt(new Date(System.currentTimeMillis()))
              .setExpiration(expireTimeFromNow())
              .signWith(SignatureAlgorithm.ES256, SECRET_KEY).compact();
   }

   private Date expireTimeFromNow(){
      return new Date(System.currentTimeMillis() + sessionTime);
   }
}
