package com.study.ainterview3.data.remote

import com.study.ainterview3.data.mapper.toDomain
import com.study.ainterview3.domain.model.Fox
import com.study.ainterview3.domain.repository.FoxRepository
import com.study.ainterview3.domain.util.Resource
import javax.inject.Inject

class FoxRepositoryImpl @Inject constructor(
    private val foxApi: FoxApi,
) : FoxRepository {
    override suspend fun getFox(): Resource<Fox> {
        return try {
            Resource.Success(
                data = foxApi.getFox().toDomain()
            )
        } catch (e: Exception) {
            Resource.Error(message = e.toString())
        }
    }
}

