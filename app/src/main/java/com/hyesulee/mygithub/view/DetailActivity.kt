package com.hyesulee.mygithub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.hyesulee.mygithub.R
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
            binding.detailToolBar.title = login
        } else {
            finish()
        }

        binding.detailToolBar.setNavigationOnClickListener { finish() }
    }

    override fun showUserDetail(result: UserDetails) {
        binding.detailProgressBar.visibility = View.GONE

        binding.usernameTextView.text = result.login
        binding.nameTextView.text = result.name
        binding.descriptionTextView.text = result.bio
        binding.followerTextView.text = result.followers.toString()
        binding.followingTextView.text =result.following.toString()

        Glide.with(applicationContext)
            .load(result.avatarUrl)
            .circleCrop()
            .placeholder(R.drawable.placeholder)
            .into(binding.detailAvatarImageView)

        binding.followerText.setOnClickListener { moveToFollowActivity(result.login, true) }
        binding.followerTextView.setOnClickListener { moveToFollowActivity(result.login, true) }
        binding.followingText.setOnClickListener { moveToFollowActivity(result.login, false) }
        binding.followingTextView.setOnClickListener { moveToFollowActivity(result.login, false) }
    }

    private fun moveToFollowActivity(login: String?, isFollower: Boolean) {
        val intent = Intent(this, FollowListActivity::class.java)
        intent.putExtra("login", login)
        intent.putExtra("isFollower", isFollower)
        startActivity(intent)
    }

    override fun showFailure(message: String) {
        binding.detailProgressBar.visibility = View.GONE
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}