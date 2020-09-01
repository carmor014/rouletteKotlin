package com.roulette.api.controllers

import com.roulette.api.dto.BetDTO
import com.roulette.api.models.entity.Roulette
import com.roulette.api.models.service.IRouletteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class RouletteController(@Autowired
                         private val rouletteService: IRouletteService) {

    @GetMapping("/ping")
    fun index(): String {
        return "pong"
    }


    @PostMapping("/roulette/{id}")
    fun createRoulette(@PathVariable id: Long): String {
        try {
            rouletteService.createRoulette(id)
            return "success"
        } catch (e: Exception) {
            println(e)
            return "failed"
        }
    }


    @PutMapping("/roulette/open/{id}")
    fun openRoulette(@PathVariable id:Long):String {
        try
        {
            val response = rouletteService.openRoulette(id)
            return response
        }
        catch (e:Exception) {
            println(e)
            return "Roulette out of order"
        }
    }



    @PostMapping("/bet")
    fun createBet(@RequestBody betDto: BetDTO, @RequestHeader(value = "User") userId:Long):String {
        try
        {
            val response = rouletteService.createBet(betDto.rouletteId, userId, betDto.betColor,
                    betDto.betNumber, betDto.betValue)
            return response
        }
        catch (e:Exception) {
            println(e)
            return "I don't know how to bet"
        }
    }




    @PutMapping("/roulette/close/{id}")
    fun closeRoulette(@PathVariable id: Long): String {
        try {
            for(roulette in openRoulette(id))
            rouletteService.closeRoulette(id)
            return "success"
        } catch (e: Exception) {
            println(e)
            return "failed"
        }
    }



    @GetMapping("/roulette")
    fun findAllRoulettes(): List<Roulette>? {
        try
        {
            return rouletteService.findAllRoulettes()
        }
        catch (e:Exception) {
            println(e)
            return null
        }
    }


}