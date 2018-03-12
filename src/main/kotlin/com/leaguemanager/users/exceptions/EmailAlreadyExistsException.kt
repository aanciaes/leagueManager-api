package com.leaguemanager.users.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus (value = HttpStatus.CONFLICT, reason = "Email already registered")
class EmailAlreadyExistsException: RuntimeException()