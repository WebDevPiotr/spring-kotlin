package com.example.light.security.auth

import com.example.light.security.auth.dto.LoginRequest
import com.example.light.security.token.HeadersFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
        private val authService: AuthService,
        private val headersFactory: HeadersFactory
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> =
            authService.login(request).let {
                ResponseEntity
                        .ok()
                        .headers(headersFactory.getHeaders(it))
                        .build()
            }
}