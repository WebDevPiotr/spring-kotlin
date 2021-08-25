package com.example.light.security.token

import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import javax.crypto.SecretKey

@Component
class JwtConstants(
        @Value("\${spring.jwt.secret}") public val SECRET: String
) {
    val EXPIRATION_TIME: Int = 864000000
    val SECRET_KEY: SecretKey? = Keys.hmacShaKeyFor(SECRET.toByteArray(Charsets.UTF_8))
    val AUTH_HEADER: String = "Authorization"
    val TOKEN_PREFIX: String = "Bearer"
}



