package com.leaguemanager.users.service

import com.leaguemanager.users.exceptions.DuplicatedUserException
import com.leaguemanager.users.exceptions.EmailAlreadyExistsException
import com.leaguemanager.users.exceptions.UserNotFoundException
import com.leaguemanager.users.model.User
import com.leaguemanager.users.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service



@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun registerUser (user: User): User {
        if (userRepository.existsById(user.id))
            throw DuplicatedUserException()

        if (userRepository.existsByMail(user.mail))
            throw EmailAlreadyExistsException()

        user.hashedPassword = passwordEncoder().encode(user.hashedPassword)
        return userRepository.save(user)
    }

    fun getUserById(userId: Long): User {

        return try{
            userRepository.findById(userId).get()
        } catch (e: NoSuchElementException) {
            throw UserNotFoundException ()
        }
    }

    private fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}