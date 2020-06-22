package com.example.service

import com.example.entities.KPopGroup
import com.example.entities.KPopGroupRequest
import com.example.repository.KPopRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityExistsException
import javax.persistence.EntityNotFoundException

@Service
class KPopService(
        private val kpopRepository: KPopRepository
) {
    fun getById(id: Long): KPopGroup {
        return kpopRepository.findById(id).orElseThrow {
            EntityNotFoundException("Group $id not found")
        }
    }

    @Transactional
    fun add(kPopGroupRequest: KPopGroupRequest): Long {
        kpopRepository.existsByName(
                kPopGroupRequest.name
        ).also { exists ->
            if (exists) {
                throw EntityExistsException(
                        "Já existe grupo de nome ${kPopGroupRequest.name}"
                )
            }
        }

        return KPopGroup(
                name = kPopGroupRequest.name,
                nickname = kPopGroupRequest.nickname,
                numberofmembers  = kPopGroupRequest.numberofmembers,
                company = kPopGroupRequest.company
        ).let {
            val savedGroupId = kpopRepository.insertGroup(it)
            savedGroupId
        }
    }
}