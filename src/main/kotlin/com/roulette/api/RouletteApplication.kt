package com.roulette.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RouletteApplication

fun main(args: Array<String>) {
	runApplication<RouletteApplication>(*args)
}
