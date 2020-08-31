package com.roulette.api.models.entity

import com.sun.istack.NotNull
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "roulettes")
class Roulette : Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0

    @NotNull
    var state:String = ""

    @Temporal(TemporalType.TIMESTAMP)
    var createAt : Date =  Date()
    companion object {
        /**
         *
         */
        private val serialVersionUID = 1L
    }
}