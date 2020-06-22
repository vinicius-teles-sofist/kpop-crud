package com.example.crudapi

import com.example.entities.KPopGroup
import com.example.entities.KPopGroupRequest
import com.example.service.KPopService
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
class KpopController(
        private val kpopService: KPopService
) {
    @GetMapping("/")
    fun crudapi(model: Model): String {
        model["title"] = "crudAPI"
        return "crudAPI"
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<KPopGroup> {
        val kpopGroup = kpopService.getById(id)
        return ResponseEntity.ok(kpopGroup)
    }

    @PostMapping
    fun add(
            @RequestBody @Valid kPopGroupRequest: KPopGroupRequest
    ): ResponseEntity<Any?> {
        val id = kpopService.add(kPopGroupRequest)
        val location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .build(id)
        return ResponseEntity.created(location).build()
    }
}