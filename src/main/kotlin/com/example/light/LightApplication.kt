package com.example.light

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LightApplication

fun main(args: Array<String>) {
    runApplication<LightApplication>(*args)
}
