package com.leaguemanager.league.service

import com.leaguemanager.league.model.League
import com.leaguemanager.league.model.LeagueRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LeagueService {

    @Autowired
    lateinit var leagueRepository: LeagueRepository

    fun createLeague (league: League): League {
        return leagueRepository.save(league)
    }

    fun getLeagueById (leagueId: Long): League {
        return leagueRepository.findById(leagueId).get()
    }
}