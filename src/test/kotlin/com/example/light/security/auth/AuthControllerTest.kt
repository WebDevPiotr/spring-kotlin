package com.example.light.security.auth

import com.example.light.base.IntegrationTest
import com.example.light.security.auth.dto.LoginRequest
import com.example.light.security.token.AUTH_HEADER
import com.example.light.user.MockUser
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@DisplayName("Auth Controller Tests")
class AuthControllerTest : IntegrationTest() {

    @Test
    @DisplayName("Sing in when user exists in database")
    fun signInWhenUserExist() {
        val request = LoginRequest(MockUser.email, MockUser.password)
        mockMvc.perform(
            post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isOk)
            .andExpect(header().exists(AUTH_HEADER))
    }

    @Test
    @DisplayName("Sing in when user does not exists in database")
    fun signInWhenUserDoesNotExist() {
        val request = LoginRequest("testWrong@gmail.com", MockUser.password)
        mockMvc.perform(
            post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isNotFound)
            .andExpect(header().doesNotExist(AUTH_HEADER))
    }

    @Test
    @DisplayName("Sing in when user exists in database and wrong password")
    fun signInWhenUserExistAndWrongPassword() {
        val request = LoginRequest(MockUser.email, "1234")
        mockMvc.perform(
            post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isForbidden)
            .andExpect(header().doesNotExist(AUTH_HEADER))
    }
}