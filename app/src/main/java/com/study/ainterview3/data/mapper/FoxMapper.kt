package com.study.ainterview3.data.mapper

import com.study.ainterview3.data.remote.response.ResponseDto
import com.study.ainterview3.domain.model.Fox

fun ResponseDto.toDomain(): Fox {
    return Fox(
        image = this.image,
        link = this.link
    )
}