package com.mvp.cidade_organica.feature.store.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StoresResponse(
    val stores: List<StoreResponse>
)

@JsonClass(generateAdapter = true)
data class StoreResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "address") val address: String,
    @Json(name = "city") val city: String,
    @Json(name = "phone") val phone: String
)