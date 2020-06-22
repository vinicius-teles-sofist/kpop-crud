package com.example.entities

import javax.persistence.*

@Entity
@Table(schema = "public", name = "kpopgroup")
data class KPopGroup(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        val name: String,
        val nickname: String? = null,
        val numberofmembers: Int,
        val company: String
)