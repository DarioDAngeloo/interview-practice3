package com.study.ainterview3.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.study.ainterview3.data.remote.FoxRepositoryImpl
import com.study.ainterview3.domain.repository.FoxRepository

@Module
@InstallIn(SingletonComponent::class)
object FoxRepositoryImpl {

    @Provides
    @Singleton
    fun provideFoxRepository(foxRepositoryImpl: FoxRepositoryImpl) : FoxRepository {
        return foxRepositoryImpl
    }

}