package com.example.light.security

import com.example.light.user.UsersRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserDetailsService(
        private  val usersRepository: UsersRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        username ?: throw UsernameNotFoundException("Username must be provided")
        val user  = usersRepository.findByEmail(username) ?: throw UserNotFoundException()
        return User(user.email, user.password, mutableListOf())
    }
}