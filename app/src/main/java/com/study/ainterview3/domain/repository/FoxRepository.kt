package com.study.ainterview3.domain.repository

import com.study.ainterview3.domain.model.Fox
import com.study.ainterview3.domain.util.Resource

interface FoxRepository {

    suspend fun getFox() : Resource<Fox>

}