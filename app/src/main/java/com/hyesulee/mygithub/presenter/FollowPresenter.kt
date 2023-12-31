package com.hyesulee.mygithub.presenter

import com.hyesulee.mygithub.contract.FollowContract
import com.hyesulee.mygithub.model.Items
import com.hyesulee.mygithub.network.RetrofitClient
import com.hyesulee.mygithub.network.SearchService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowPresenter(val view: FollowContract.View): FollowContract.Presenter {
    private var searchService: SearchService = RetrofitClient.searchService
    override fun getFollowerList(login: String) {
        val call = searchService.getFollowers(login)
        call.enqueue(object : Callback<ArrayList<Items>> {
            override fun onResponse(call: Call<ArrayList<Items>>, response: Response<ArrayList<Items>>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        view.showFollowList(body)
                    } else {
                        setMessage("Empty response body")
                    }
                } else {
                    setMessage(response.message())
                }
            }

            override fun onFailure(call: Call<ArrayList<Items>>, t: Throwable) {
                setMessage(t.message)
            }
        })
    }

    override fun getFollowingList(login: String) {
        val call = searchService.getFollowing(login)
        call.enqueue(object : Callback<ArrayList<Items>> {
            override fun onResponse(call: Call<ArrayList<Items>>, response: Response<ArrayList<Items>>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        view.showFollowList(body)
                    } else {
                        setMessage("Empty response body")
                    }
                } else {
                    setMessage(response.message())
                }
            }

            override fun onFailure(call: Call<ArrayList<Items>>, t: Throwable) {
                setMessage(t.message)
            }
        })
    }

    private fun setMessage(message: String?) {
        val errorMessage = "Network request failed: $message"
        view.showFailure(errorMessage)
    }
}