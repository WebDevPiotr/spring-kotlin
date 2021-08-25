package com.example.light.security.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenFactory {

    fun createToken(email: String): String =
            Jwts.builder()
                    .setSubject(email)
                    .signWith(JwtConstants.SECRET_KEY, SignatureAlgorithm.HS256 )
                    .setExpiration(Date(Date().time + JwtConstants.EXPIRATION_TIME))
                    .compact();
}