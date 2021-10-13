package com.example.light.security.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenValidator(
    private val secretProvider: SecretProvider
) {

    fun validate(token: String): Boolean =
        try {
            Jwts.parserBuilder()
                .setSigningKey(secretProvider.secretKey)
                .build()
                .parseClaimsJws(token)
                .body
                .expiration
                .after(Date())
        } catch (e: Exception) {
            false
        }
}