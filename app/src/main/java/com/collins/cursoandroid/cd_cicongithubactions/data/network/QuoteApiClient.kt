package com.collins.cursoandroid.cd_cicongithubactions.data.network

import com.collins.cursoandroid.cd_cicongithubactions.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}