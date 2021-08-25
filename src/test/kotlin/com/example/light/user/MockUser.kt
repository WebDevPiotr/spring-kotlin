package com.example.light.user

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object MockUser {
    var email: String = "test@gmail.com"
    var password: String = "123"
    fun getMockedUser(): User =
        User().apply {
            id = 1
            email = MockUser.email
            password = BCryptPasswordEncoder().encode(MockUser.password)
        }
}