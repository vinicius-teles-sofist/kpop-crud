package com.example.entities

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class KPopGroupRequest(
//        @field:NotBlank
        val name: String,
        val nickname: String? = null,
//        @field:NotNull
        val numberofmembers: Int,
//        @field:NotBlank
        val company: String
)