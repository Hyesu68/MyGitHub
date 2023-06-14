package com.hyesulee.mygithub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                presenter.getFollowerList(login)
            } else {
                presenter.getFollowingList(login)
            }
        } else {
            finish()
        }
    }

    override fun showFollowList(result: ArrayList<Items>) {
        searchAdapter = SearchResultsAdapter(result)
        binding.followRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.followRecyclerView.adapter = searchAdapter
    }

    override fun showFailure(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}