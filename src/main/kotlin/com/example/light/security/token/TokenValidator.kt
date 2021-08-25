package com.example.light.security.token

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenValidator {

    fun validate(token: String): Boolean =
            try {
                Jwts.parserBuilder()
                        .setSigningKey(JwtConstants.SECRET_KEY)
                        .build()
                        .parseClaimsJws(token)
                        .body
                        .expiration
                        .after(Date())
            } catch (e: Exception) {
                false
            }
}