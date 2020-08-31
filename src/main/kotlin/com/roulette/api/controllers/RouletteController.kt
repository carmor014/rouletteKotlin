package com.roulette.api.controllers

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
}