package com.roulette.api.models.service

import com.roulette.api.models.dao.IBetDao
import com.roulette.api.models.dao.IRouletteDao
import com.roulette.api.models.entity.Roulette
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class RouletteServiceImpl(
        @Autowired private val rouletteDao: IRouletteDao,
        @Autowired private val betDao: IBetDao
) :IRouletteService {

    @Transactional
    override fun createRoulette(id: Long) {
        val date = Date()
        rouletteDao.createRoulette(id, "close", date)
    }



    @Transactional
    override fun openRoulette(id: Long):String {
        val result = rouletteDao.changeStateRoulette(id, "open")
        if (result == 1)
        {
            return "open roulette"
        }
        else
        {
            return "roulette does not exist"
        }
    }


    @Transactional
    override fun createBet(
            rouletteId: Long, userId: Long, betColor: String, betNumber: Long,
            betValue: Double): String {
        val state: String = rouletteDao.findRoulettesById(rouletteId)!!.state

        return if (state == "open" && betNumber > 0 && betNumber < 36 && betValue > 0 && betValue < 10000
                || betColor == "black" || betColor == "red") {
            val betDate = Date()
            val roundId: Long = 12 // quitar
            betDao.createBet(rouletteId, userId, roundId, betColor, betNumber, betValue, betDate)
            "success"
        } else {
            "Closed roulette"
        }
    }

    @Transactional
    override fun closeRoulette(id: Long):String {
        val result = rouletteDao.changeStateRoulette(id, "close")
        if (result == 0)
        {
            return "close roulette"
        }
        else
        {
            return "roulette does not exist"
        }
    }

    override fun findAllRoulettes():List<Roulette> {
        return rouletteDao.findAllRoulettes()
    }

}