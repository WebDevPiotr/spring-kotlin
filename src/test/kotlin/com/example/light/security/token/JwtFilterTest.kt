package com.example.light.security.token

import com.example.light.base.IntegrationTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@DisplayName("Jwt Filter Test")
class JwtFilterTest : IntegrationTest() {

    @Test
    @DisplayName("Check if filter works when token is valid")
    fun checkIfJwtFilterWorksWhenTokenProvided() {
        mockMvc.perform(
            get("/users")
                .header("Authorization", "$TOKEN_PREFIX $token")
        )
            .andExpect(status().isOk)
    }

    @Test
    @DisplayName("Check if throw error when no token provided")
    fun checkIfJwtFilterWorksWhenNoTokenProvided() {
        mockMvc.perform(
            get("/users")
        )
            .andExpect(status().isUnauthorized)
    }

    @Test
    @DisplayName("Check if throw error when token is encoded with wrong secret")
    fun checkIfJwtFilterWorksWhenTokenEncodedWithWrongSecret() {
        mockMvc.perform(
            get("/users")
                .header("Authorization", "$TOKEN_PREFIX ${MockToken.getTokenWithWrongSecret()}")
        )
            .andExpect(status().isUnauthorized)
    }

    @Test
    @DisplayName("Check if throw error when token is expired")
    fun checkIfJwtFilterWorksWhenTokenIsExpired() {
        mockMvc.perform(
            get("/users")
                .header("Authorization", "$TOKEN_PREFIX ${MockToken.getExpiredToken()}")
        )
            .andExpect(status().isUnauthorized)
    }


}