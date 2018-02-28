package com.leaguemanager.league.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class League(@Id @GeneratedValue(strategy = GenerationType.AUTO)
             val id: Long = -1,
             val name: String = "", val managerId: Long = -1) {


    fun validate(): Boolean {
        return name != "" && managerId != -1L
    }
}
