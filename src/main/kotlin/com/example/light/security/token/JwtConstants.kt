package com.example.light.security.token

import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import javax.crypto.SecretKey

object JwtConstants {
    @Value("\${spring.jwt.secret}")
    var SECRET: String = "dasdasdasdsadasdasdasdasdasdasdasdasda"
    var EXPIRATION_TIME: Int = 864000000
    var SECRET_KEY: SecretKey? = Keys.hmacShaKeyFor(SECRET.toByteArray(Charsets.UTF_8))
    var AUTH_HEADER: String = "Authorization"
    var TOKEN_PREFIX: String = "Bearer"
}




