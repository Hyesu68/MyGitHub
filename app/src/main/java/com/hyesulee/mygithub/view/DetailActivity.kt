package com.hyesulee.mygithub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hyesulee.mygithub.contract.DetailContract
import com.hyesulee.mygithub.databinding.ActivityDetailBinding
import com.hyesulee.mygithub.model.UserDetails
import com.hyesulee.mygithub.presenter.DetailPresenter

class DetailActivity : AppCompatActivity(), DetailContract.View {
    private lateinit var binding: ActivityDetailBinding
    private val presenter: DetailContract.Presenter = DetailPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val login = intent.getStringExtra("login")
        if (login != null) {
            presenter.getUserDetail(login)
        } else {
            finish()
        }
    }

    override fun showUserDetail(result: UserDetails) {
        binding.usernameTextView.text = result.login
        binding.nameTextView.text = result.name
        binding.descriptionTextView.text = result.bio
        binding.followerTextView.text = result.followers.toString()
        binding.followingTextView.text =result.following.toString()

        Glide.with(applicationContext)
            .load(result.avatarUrl)
            .circleCrop()
            .into(binding.detailAvatarImageView)
    }

    override fun showFailure(message: String) {

    }
}