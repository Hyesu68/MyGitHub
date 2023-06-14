package com.hyesulee.mygithub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyesulee.mygithub.contract.FollowContract
import com.hyesulee.mygithub.databinding.ActivityFollowListBinding
import com.hyesulee.mygithub.model.Items
import com.hyesulee.mygithub.presenter.FollowPresenter

class FollowListActivity : AppCompatActivity(), FollowContract.View {
    private lateinit var binding: ActivityFollowListBinding
    private val presenter: FollowContract.Presenter = FollowPresenter(this)
    private lateinit var searchAdapter: SearchResultsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFollowListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val login = intent.getStringExtra("login")
        val isFollower = intent.getBooleanExtra("isFollower", false)
        if (login != null) {
            if (isFollower) {
                binding.followToolBar.title = "Followers"
                presenter.getFollowerList(login)
            } else {
                binding.followToolBar.title = "Following"
                presenter.getFollowingList(login)
            }
        } else {
            finish()
        }

        binding.followToolBar.setNavigationOnClickListener { finish() }
    }

    override fun showFollowList(result: ArrayList<Items>) {
        binding.followProgressBar.visibility = View.GONE

        if (result.size == 0) {
            binding.followNotFoundTextView.visibility = View.VISIBLE
        }

        searchAdapter = SearchResultsAdapter(result)
        binding.followRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.followRecyclerView.adapter = searchAdapter
    }

    override fun showFailure(message: String) {
        binding.followProgressBar.visibility = View.GONE
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}