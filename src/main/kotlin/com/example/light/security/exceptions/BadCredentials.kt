package com.example.light.security.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.FORBIDDEN)
class BadCredentials(msg: String = "Bad credentials") : Exception(msg)