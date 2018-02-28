package com.leaguemanager.league.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class League (val name: String, val managerId: Long) {

    @Id
    @GeneratedValue
    val id: Long = 0

}
