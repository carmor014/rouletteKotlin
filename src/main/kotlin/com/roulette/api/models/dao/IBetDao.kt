package com.roulette.api.models.dao

import com.roulette.api.models.entity.Bet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface IBetDao: JpaRepository<Bet, Long> {
    @Modifying
    @Query(value = ("insert into Bets (roulette_id, user_id, round_id, bet_color, bet_number, bet_value, bet_date ) " + "values (:roulette_id,:user_id,:round_id,:bet_color,:bet_number,:bet_value,:bet_date) "), nativeQuery = true)
    fun createBet(@Param("roulette_id") roulette_id:Long, @Param("user_id") user_id:Long,
                  @Param("round_id") round_id:Long, @Param("bet_color") bet_color:String,
                  @Param("bet_number") bet_number:Long, @Param("bet_value") bet_value:Double,
                  @Param("bet_date") bet_date: Date
    )
    @Modifying
    @Query(value = "select * from Bets where roulette_id = :roulette_id", nativeQuery = true)
    fun getAllBetsByIdRoulette(@Param("roulette_id") roulette_id:Long):List<Bet>
}