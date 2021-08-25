package com.example.light.security.token

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenValidator(
        private val jwtConstants: JwtConstants
) {

    fun validate(token: String): Boolean =
            try {
                Jwts.parserBuilder()
                        .setSigningKey(jwtConstants.SECRET_KEY)
                        .build()
                        .parseClaimsJws(token)
                        .body
                        .expiration
                        .after(Date())
            } catch (e: Exception) {
                false
            }
}