package com.example.light.security.token

import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component

@Component
class HeadersFactory {

    fun getHeaders(token: String): HttpHeaders =
            HttpHeaders().apply {
                add(JwtConstants.AUTH_HEADER, "${JwtConstants.TOKEN_PREFIX} $token")
            }
}