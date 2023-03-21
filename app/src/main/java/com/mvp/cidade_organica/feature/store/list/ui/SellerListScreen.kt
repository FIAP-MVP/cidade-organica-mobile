package com.mvp.cidade_organica.feature.store.list.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mvp.cidade_organica.feature.store.StoreResult
import com.mvp.cidade_organica.feature.store.StoreViewModel
import com.mvp.cidade_organica.feature.store.domain.Store
import org.koin.androidx.compose.koinViewModel

@Composable
fun SellerListScreen(navController: NavHostController) {
    StoreList()
}

@Composable
fun StoreList(viewModel: StoreViewModel = koinViewModel()){
    LaunchedEffect(Unit) {
        viewModel.loadStores()
    }

    val lazyStores = viewModel.stores
    when (val result = lazyStores.value) {
        is StoreResult.Success -> {
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                items(result.stores) { store ->
                    StoreItem(store = store)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        is StoreResult.Error -> {
            Text(text = stringResource(id = result.code))
        }
        else -> {

        }
    }
}


@Composable
fun StoreItem(store: Store) {
    with(store) {
        Card(modifier = Modifier.fillMaxWidth()) {

            Column {
                Text(text = name)
                Text(text = phone)
                Text(text = address)
                Text(text = city)
            }
        }
    }
}