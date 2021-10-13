package com.example.light.security.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.*

object MockToken {
    var email: String = "test@gmail.com"

    fun getExpiredToken(): String =
        Jwts.builder()
            .setSubject(email)
            .signWith(Keys.hmacShaKeyFor("asdasdsadasdasdsadasdsadsadasdasdasdasd".toByteArray(Charsets.UTF_8)), SignatureAlgorithm.HS256 )
            .setExpiration(Date(Date().time - EXPIRATION_TIME))
            .compact();

    fun getTokenWithWrongSecret(): String =
        Jwts.builder()
            .setSubject(email)
            .signWith(Keys.hmacShaKeyFor("sdasdasdasdasdasdasdasdsdasdasdasdasdasdasdasdasdasda".toByteArray(Charsets.UTF_8)), SignatureAlgorithm.HS256 )
            .setExpiration(Date(Date().time + EXPIRATION_TIME))
            .compact();
}