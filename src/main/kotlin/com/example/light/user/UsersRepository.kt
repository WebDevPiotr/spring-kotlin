package com.example.light.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path="users", itemResourceRel = "users")
interface UsersRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}