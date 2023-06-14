package com.hyesulee.mygithub.network

import com.hyesulee.mygithub.model.Items
import com.hyesulee.mygithub.model.UserDetails
import com.hyesulee.mygithub.model.UsersData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchService {
    @GET("search/users")
    fun getSearchResults(
        @Query("q") query: String,
    ): Call<UsersData>

    @GET("users/{username}")
    fun getUserDetail(
        @Path("username") username: String,
    ): Call<UserDetails>

    @GET("users/{username}/followers")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<Items>>

    @GET("users/{username}/following")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<Items>>
}