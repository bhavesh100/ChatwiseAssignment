package com.bhavesh.chatwiseassignment.domain.use_case

import com.bhavesh.chatwiseassignment.common.Resource
import com.bhavesh.chatwiseassignment.data.remote.dto.Product
import com.bhavesh.chatwiseassignment.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductsRepository
) {
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getProductsDto().products
            emit(Resource.Success(data))

        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("${e.message}"))
        }
    }
}