package com.hyesulee.mygithub.contract

import com.hyesulee.mygithub.model.Items

interface FollowContract {
    interface View {
        fun showFollowList(result: ArrayList<Items>)
        fun showFailure(message: String)
    }

    interface Presenter {
        fun getFollowerList(login: String)
        fun getFollowingList(login: String)
    }
}