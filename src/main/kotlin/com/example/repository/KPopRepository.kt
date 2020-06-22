package com.example.repository

import com.example.entities.KPopGroup
import org.springframework.data.repository.CrudRepository

///metodos de crud do banco
interface KPopRepository: CrudRepository<KPopGroup, Long> {

    fun existsByName(
            name: String
    ): Boolean

    fun findAllByCompany(
            company: String
    ): List<KPopGroup>

    fun insertGroup(
            kPopGroup: KPopGroup
    ): Long
}