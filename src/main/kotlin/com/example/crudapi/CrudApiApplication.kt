package com.example.crudapi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableAutoConfiguration
@ComponentScan(basePackages = ["com.example"])
@ConfigurationPropertiesScan(basePackages = ["com.example"])
@EnableJpaRepositories(basePackages = ["com.example.repository"])
@EntityScan(basePackages = ["com.example.entities"])
class CrudApiApplication

fun main(args: Array<String>) {
    runApplication<CrudApiApplication>(*args) {
    }
}