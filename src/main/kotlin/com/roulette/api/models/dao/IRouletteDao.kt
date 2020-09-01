package com.roulette.api.models.dao

import com.roulette.api.models.entity.Roulette
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*


interface IRouletteDao: JpaRepository<Roulette, Long> {
    @Modifying
    @Query(value = "insert into Roulettes (id ,state, create_at ) values (:id,:state,:create_at) ", nativeQuery = true)
    fun createRoulette(@Param("id") id: Long, @Param("state") state: String, @Param("create_at") create_at: Date)


    @Modifying
    @Query(value = "update Roulettes set state = :state where id = :id", nativeQuery = true)
    fun changeStateRoulette(@Param("id") id: Long, @Param("state") state: String): Int

    @Query(value = "select * from Roulettes  where id = :id ", nativeQuery = true)
    fun findRoulettesById(@Param("id") id: Long?): Roulette?

    @Modifying
    @Query(value = "select * from Roulettes", nativeQuery = true)
    fun findAllRoulettes():List<Roulette>

}