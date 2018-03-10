package com.leaguemanager.users.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong email format")
class WrongFormatEmailException: RuntimeException ()