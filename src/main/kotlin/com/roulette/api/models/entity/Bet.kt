package com.roulette.api.models.entity

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "bets")
class Bet : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0

    var rouletteId:Long = 0
    var userId:Long = 0
    var roundId:Long = 0
    var betColor:String = ""
    var betNumber:Long = 0
    var betValue:Double = 0.0

    @Temporal(TemporalType.TIMESTAMP)
    var betDate: Date = Date()
    companion object {
        /**
         *
         */
        private val serialVersionUID = 1L
    }
}