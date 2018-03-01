package com.leaguemanager.league.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus (value = HttpStatus.BAD_REQUEST, reason = "JSON input might be wrong")
class BadRequestException : RuntimeException()