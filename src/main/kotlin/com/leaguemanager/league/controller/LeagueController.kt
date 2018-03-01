package com.leaguemanager.league.controller

import com.leaguemanager.league.exceptions.BadRequestException
import com.leaguemanager.league.model.League
import com.leaguemanager.league.service.LeagueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "/league")
class LeagueController {

    @Autowired
    lateinit var leagueService : LeagueService

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun createLeague (@RequestBody league: League): League {
        if(!league.validate()){
            throw BadRequestException()
        }
        return leagueService.createLeague(league)
    }

    @RequestMapping(value = "/{leagueId}", method = arrayOf(RequestMethod.GET))
    fun getLeagueById (@PathVariable leagueId: Long): League {
        return leagueService.getLeagueById(leagueId)
    }
}