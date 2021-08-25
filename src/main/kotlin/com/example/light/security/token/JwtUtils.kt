package com.example.light.security.token

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component

@Component
class JwtUtils{

    fun getSubject(token: String): String =
            Jwts.parserBuilder()
                    .setSigningKey(JwtConstants.SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .body
                    .subject
}