package com.leaguemanager.league.controller

import com.leaguemanager.league.model.League
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/league")
class LeagueController {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun createLeague (league: League) {
        println ("First Controller")
    }
}