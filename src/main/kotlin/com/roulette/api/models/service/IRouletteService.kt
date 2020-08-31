package com.roulette.api.models.service

import com.roulette.api.models.entity.Roulette

interface IRouletteService {

    fun createRoulette(id: Long)
/*
    fun openRoulette(id: Long): String

    fun createBet(rouletteId: Long, userId: Long,
                  betColor: String, betNumber: Long, betValue: Double): String

    //fun closeRoulette(id: Long): List<Bet>

    fun findAllRoulettes(): List<Roulette>
*/
}