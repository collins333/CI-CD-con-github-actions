package com.collins.cursoandroid.cd_cicongithubactions.domain

import com.collins.cursoandroid.cd_cicongithubactions.data.QuoteRepository
import com.collins.cursoandroid.cd_cicongithubactions.data.model.QuoteModel
import com.collins.cursoandroid.cd_cicongithubactions.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}