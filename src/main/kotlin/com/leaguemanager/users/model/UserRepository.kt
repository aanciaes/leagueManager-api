package com.leaguemanager.users.model

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {


    fun existsByMail (email: String): Boolean

}