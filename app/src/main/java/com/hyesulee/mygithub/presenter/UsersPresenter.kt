package com.hyesulee.mygithub.presenter

import com.hyesulee.mygithub.contract.UsersContract
import com.hyesulee.mygithub.model.UsersData
import com.hyesulee.mygithub.network.RetrofitClient
import com.hyesulee.mygithub.network.SearchService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersPresenter(val view: UsersContract.View): UsersContract.Presenter {
    private var searchService: SearchService = RetrofitClient.searchService
    override fun getUsers(q: String) {
        val call = searchService.getSearchResults(q)
        call.enqueue(object : Callback<UsersData> {
            override fun onResponse(call: Call<UsersData>, response: Response<UsersData>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        view.showUsers(body.items)
                    }
                }
            }

            override fun onFailure(call: Call<UsersData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}