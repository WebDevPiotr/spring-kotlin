package com.example.light.security.token

import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component

@Component
class HeadersFactory(
        private val jwtConstants: JwtConstants
) {

    fun getHeaders(token: String): HttpHeaders =
            HttpHeaders().apply {
                add(jwtConstants.AUTH_HEADER, "${jwtConstants.TOKEN_PREFIX} $token")
            }
}