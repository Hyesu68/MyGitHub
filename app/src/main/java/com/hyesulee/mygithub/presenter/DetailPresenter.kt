package com.hyesulee.mygithub.presenter

import com.hyesulee.mygithub.contract.DetailContract
import com.hyesulee.mygithub.model.UserDetails
import com.hyesulee.mygithub.network.RetrofitClient
import com.hyesulee.mygithub.network.SearchService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(val view: DetailContract.View): DetailContract.Presenter {
    private var searchService: SearchService = RetrofitClient.searchService
    override fun getUserDetail(login: String) {
        val call = searchService.getUserDetail(login)
        call.enqueue(object : Callback<UserDetails> {
            override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        view.showUserDetail(body)
                    } else {
                        setMessage("Empty response body")
                    }
                } else {
                    setMessage(response.message())
                }
            }

            override fun onFailure(call: Call<UserDetails>, t: Throwable) {
                setMessage(t.message)
            }
        })
    }

    private fun setMessage(message: String?) {
        val errorMessage = "Network request failed: $message"
        view.showFailure(errorMessage)
    }
}