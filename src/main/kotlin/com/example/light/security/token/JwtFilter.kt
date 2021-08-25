package com.example.light.security.token

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtFilter(
        private val tokenValidator: TokenValidator,
        private val jwtUtils: JwtUtils,
        private val jwtConstants: JwtConstants
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val token = request.getHeader(jwtConstants.AUTH_HEADER)
        if(token == null || !token.startsWith(jwtConstants.TOKEN_PREFIX)){
            filterChain.doFilter(request, response)
            return;
        }

        val rawToken = token.split(" ")[1].trim();
        if(!tokenValidator.validate(rawToken)){
            filterChain.doFilter(request, response)
            return;
        }

        val email = jwtUtils.getSubject(rawToken);
        SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(email, null, emptyList())
        filterChain.doFilter(request, response)
    }

}