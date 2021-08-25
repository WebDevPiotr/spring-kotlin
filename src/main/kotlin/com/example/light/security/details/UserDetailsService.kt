package com.example.light.security.details

import com.example.light.security.exceptions.UserNotFoundException
import com.example.light.user.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserDetailsService(
        private val usersRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        username ?: throw UsernameNotFoundException("Username must be provided")
        return usersRepository.findByEmail(username)?.let {
            User(it.email, it.password, mutableListOf())
        } ?: throw UserNotFoundException()
    }
}