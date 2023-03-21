package com.mvp.cidade_organica.feature.store.data

import com.mvp.cidade_organica.Result
import com.mvp.cidade_organica.feature.store.domain.Store

class StoreRepository(private val storeService: StoreDataSource) {

    suspend fun listStores() : Result<List<Store>> {
        return storeService.loadStores()
    }
}