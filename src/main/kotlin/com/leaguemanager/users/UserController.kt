package com.leaguemanager.users

import com.leaguemanager.users.model.User
import com.leaguemanager.users.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun registerUser (@RequestBody user: User): User {
        return userService.registerUser(user)
    }

    @RequestMapping (value = "/{userId}", method = arrayOf(RequestMethod.GET))
    fun getUser (@PathVariable userId: Long): User {
        return userService.getUserById (userId)
    }
}