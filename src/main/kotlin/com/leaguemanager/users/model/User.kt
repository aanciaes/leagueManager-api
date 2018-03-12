package com.leaguemanager.users.model

import com.leaguemanager.league.model.League
import javax.persistence.*
import javax.validation.constraints.Email

@Entity
class User (@Id @GeneratedValue(strategy = GenerationType.AUTO)
            var id: Long,

            var name: String,

            @Email @Column (unique = true)
            var mail : String,

            var hashedPassword: String) {

    @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    @JoinColumn(name = "managerId")
    var leagues: List<League> = mutableListOf()
}