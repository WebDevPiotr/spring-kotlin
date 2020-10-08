package com.example.light.powerSupply

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "powerSupplies", itemResourceRel = "powerSupplies")
interface PowerSuppliesRepository : JpaRepository<PowerSupply, Long>