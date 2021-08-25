package com.example.light.security.token

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component

@Component
class JwtUtils(
        private val jwtConstants: JwtConstants
) {

    fun getSubject(token: String): String =
            Jwts.parserBuilder()
                    .setSigningKey(jwtConstants.SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .body
                    .subject
}