package com.example.light.security.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenFactory(
    private val secretProvider: SecretProvider
) {

    fun createToken(email: String): String =
        Jwts.builder()
            .setSubject(email)
            .signWith(secretProvider.secretKey, SignatureAlgorithm.HS256)
            .setExpiration(Date(Date().time + EXPIRATION_TIME))
            .compact();
}