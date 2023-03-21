package com.mvp.cidade_organica.feature.store.domain

data class Store(
    val id: Long,
    val name: String,
    val address: String,
    val city: String,
    val phone: String
)