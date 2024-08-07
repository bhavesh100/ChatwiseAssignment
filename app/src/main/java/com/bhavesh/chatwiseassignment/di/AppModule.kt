package com.bhavesh.chatwiseassignment.di

import com.bhavesh.chatwiseassignment.common.Constant
import com.bhavesh.chatwiseassignment.data.remote.ProductsApi
import com.bhavesh.chatwiseassignment.data.repository.ProductsRepositoryImpl
import com.bhavesh.chatwiseassignment.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductsApi(): ProductsApi {
        return Retrofit.Builder()
            .baseUrl(Constant.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsRepository(api: ProductsApi):ProductsRepository {
        return ProductsRepositoryImpl(api)
    }

}