package com.roulette.api.models.service

import com.roulette.api.models.dao.IRouletteDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class RouletteServiceImpl(@Autowired
                          private val rouletteDao: IRouletteDao) :IRouletteService {

    @Transactional
    override fun createRoulette(id: Long) {
        val date = Date()
        rouletteDao.createRoulette(id, "close", date)
    }

}