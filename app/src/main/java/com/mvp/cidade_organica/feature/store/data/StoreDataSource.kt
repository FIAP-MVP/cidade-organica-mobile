package com.mvp.cidade_organica.feature.store.data

import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.store.data.mapper.toDomain
import com.mvp.cidade_organica.feature.store.domain.Store
import com.mvp.cidade_organica.network.API
import java.io.IOException

class StoreDataSource(private val api: API) {

    suspend fun loadStores(): Result<List<Store>> {

        return try {
            val result = api.listStores()
            if (result.body() != null) {
                Result.Success(result.body()!!.map { it.toDomain() })
            } else {
                Result.Error(Exception())
            }
        } catch (e: Throwable) {
            Result.Error(IOException("Error fetching stores", e))
        }
    }
}