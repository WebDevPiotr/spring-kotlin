package com.example.light.security.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenFactory(
        private val jwtConstants: JwtConstants
) {

    fun createToken(email: String): String =
            Jwts.builder()
                    .setSubject(email)
                    .signWith(jwtConstants.SECRET_KEY, SignatureAlgorithm.HS256 )
                    .setExpiration(Date(Date().time + jwtConstants.EXPIRATION_TIME))
                    .compact();
}