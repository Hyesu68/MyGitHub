package com.hyesulee.mygithub.contract

import com.hyesulee.mygithub.model.Items

interface UsersContract {
    interface View {
        fun showUsers(result: ArrayList<Items>)
        fun showFailure(message: String)
    }

    interface Presenter {
        fun getUsers(q: String)
    }
}