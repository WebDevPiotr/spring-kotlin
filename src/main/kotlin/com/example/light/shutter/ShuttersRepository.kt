package com.example.light.shutter

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "shutters", itemResourceRel = "shutters")
interface ShuttersRepository : JpaRepository<Shutter, Long>