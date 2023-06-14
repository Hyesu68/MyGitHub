package com.hyesulee.mygithub.network

import com.hyesulee.mygithub.model.UsersData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("search/users")
    fun getSearchResults(
        @Query("q") query: String,
    ): Call<UsersData>
}