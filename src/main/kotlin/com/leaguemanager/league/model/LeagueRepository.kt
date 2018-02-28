package com.leaguemanager.league.model

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LeagueRepository: CrudRepository <League, Long> {
}