package com.collins.cursoandroid.cd_cicongithubactions.domain.model

import com.collins.cursoandroid.cd_cicongithubactions.data.database.entities.QuoteEntity
import com.collins.cursoandroid.cd_cicongithubactions.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)