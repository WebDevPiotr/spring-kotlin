package com.example.light.user

import com.example.light.base.IntegrationTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@DisplayName("User Controller Tests")
class UserControllerTest : IntegrationTest() {

    @Test
    @DisplayName("Check if token filter works")
    fun signInWhenUserExist() {
        mockMvc.perform(
            get("/users")
        )
            .andExpect(status().isUnauthorized)
    }

}