package com.collins.cursoandroid.cd_cicongithubactions.data

import com.collins.cursoandroid.cd_cicongithubactions.data.database.dao.QuoteDao
import com.collins.cursoandroid.cd_cicongithubactions.data.database.entities.QuoteEntity
import com.collins.cursoandroid.cd_cicongithubactions.data.model.QuoteModel
import com.collins.cursoandroid.cd_cicongithubactions.data.network.QuoteService
import com.collins.cursoandroid.cd_cicongithubactions.domain.model.Quote
import com.collins.cursoandroid.cd_cicongithubactions.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}