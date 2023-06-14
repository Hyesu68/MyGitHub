package com.hyesulee.mygithub.contract

import com.hyesulee.mygithub.model.Items

interface UsersContract {
    interface View {
        fun showUsers(result: ArrayList<Items>)
    }

    interface Presenter {
        fun getUsers(q: String)
    }
}