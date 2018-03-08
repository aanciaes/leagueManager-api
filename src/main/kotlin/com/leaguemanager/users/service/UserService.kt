package com.leaguemanager.users.service

import com.leaguemanager.users.exceptions.UserNotFoundException
import com.leaguemanager.users.model.User
import com.leaguemanager.users.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun registerUser (user: User): User {
        return userRepository.save(user)
    }

    fun getUserById(userId: Long): User {

        return try{
            userRepository.findById(userId).get()
        } catch (e: NoSuchElementException) {
            throw UserNotFoundException ()
        }
    }
}