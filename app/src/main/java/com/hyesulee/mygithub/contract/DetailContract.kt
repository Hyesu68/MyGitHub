package com.hyesulee.mygithub.contract

import com.hyesulee.mygithub.model.UserDetails

interface DetailContract {
    interface View {
        fun showUserDetail(result: UserDetails)
        fun showFailure(message: String)
    }

    interface Presenter {
        fun getUserDetail(login: String)
    }
}