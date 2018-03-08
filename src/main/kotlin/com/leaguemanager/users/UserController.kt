package com.leaguemanager.users

import com.leaguemanager.users.model.User
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
class UserController {


    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun testController (): User {
        return User (1, "Reis", "reis")
    }

}