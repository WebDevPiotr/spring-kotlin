package com.example.light.security.token

import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component

@Component
class HeadersFactory {

    fun getHeaders(token: String): HttpHeaders =
            HttpHeaders().apply {
                add(AUTH_HEADER, "$TOKEN_PREFIX $token")
            }
}