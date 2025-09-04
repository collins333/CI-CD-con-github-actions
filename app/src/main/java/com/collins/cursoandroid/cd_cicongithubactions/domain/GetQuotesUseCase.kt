package com.collins.cursoandroid.cd_cicongithubactions.domain

import com.collins.cursoandroid.cd_cicongithubactions.data.QuoteRepository
import com.collins.cursoandroid.cd_cicongithubactions.data.database.entities.toDatabase
import com.collins.cursoandroid.cd_cicongithubactions.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}