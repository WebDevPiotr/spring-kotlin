package com.example.light.security.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtUtils(
    private val secretProvider: SecretProvider
) {

    fun getSubject(token: String): String =
        Jwts.parserBuilder()
            .setSigningKey(secretProvider.secretKey)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
}