package com.sisgebi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String SECRET_KEY = "gcG1vC6sEorGEZSvIssHFGF+UEqGDkQmQdP1B4bPirx2/dp89DEXPM7Q2Kd9FHcvhfRRK04DeABzZUZLIvmCGg==";
    private final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos

    @SuppressWarnings("deprecation")
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            // Decodifica la clave secreta en Base64
            byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
            Jwts.parserBuilder()
                    .setSigningKey(decodedKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaimsFromToken(String token) {
        // Decodifica la clave secreta en Base64
        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
        return Jwts.parserBuilder()
                .setSigningKey(decodedKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
