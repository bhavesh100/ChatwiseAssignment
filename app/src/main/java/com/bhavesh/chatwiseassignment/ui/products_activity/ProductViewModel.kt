package com.bhavesh.chatwiseassignment.ui.products_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavesh.chatwiseassignment.common.Resource
import com.bhavesh.chatwiseassignment.domain.use_case.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {
    private val _state = MutableStateFlow(ProductsState())
    val state: StateFlow<ProductsState> = _state

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        getProductsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ProductsState(data = result.data!!.map { it.toProduct() })
                }
                is Resource.Error -> {
                    _state.value = ProductsState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = ProductsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}