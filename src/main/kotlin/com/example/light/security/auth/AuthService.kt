package com.example.light.security.auth

import com.example.light.security.auth.dto.LoginRequest
import com.example.light.security.details.UserDetailsService
import com.example.light.security.exceptions.BadCredentials
import com.example.light.security.exceptions.UserNotFoundException
import com.example.light.security.token.JwtTokenFactory
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val tokenFactory: JwtTokenFactory,
    private val userDetailsService: UserDetailsService,
    private val authenticationManager: AuthenticationManager
) {

    fun login(request: LoginRequest): String =
        userDetailsService.loadUserByUsername(request.email).let {
            try {
                authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken(request.email, request.password)
                )
            } catch (e: Exception) { throw BadCredentials() }
            tokenFactory.createToken(it.username)
        }
}