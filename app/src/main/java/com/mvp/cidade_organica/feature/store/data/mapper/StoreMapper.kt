package com.mvp.cidade_organica.feature.store.data.mapper

import com.mvp.cidade_organica.feature.store.domain.Store
import com.mvp.cidade_organica.feature.store.data.StoreResponse

fun StoreResponse.toDomain() = Store(
    id = id,
    name = name,
    address = address,
    city = city,
    phone = phone
)