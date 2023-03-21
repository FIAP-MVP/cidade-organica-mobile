package com.mvp.cidade_organica.feature.store

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvp.cidade_organica.R
import com.mvp.cidade_organica.feature.store.data.StoreRepository
import com.mvp.cidade_organica.feature.store.domain.Store
import com.mvp.cidade_organica.Result
import kotlinx.coroutines.launch

sealed class StoreResult {
    class Success(val stores: List<Store>) : StoreResult()
    class Error(val code: Int) : StoreResult()
    object Default : StoreResult()
}

class StoreViewModel(private val storeRepository: StoreRepository) : ViewModel() {

    private val _stores = mutableStateOf<StoreResult>(StoreResult.Default)
    val stores: State<StoreResult> = _stores

    fun loadStores() {
        viewModelScope.launch {
            val result = storeRepository.listStores()

            _stores.value = if (result is Result.Success) {
                StoreResult.Success(result.data)
            } else {
                StoreResult.Error(R.string.store_fetch_error)
            }
        }
    }
}