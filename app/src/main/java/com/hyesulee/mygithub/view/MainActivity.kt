package com.hyesulee.mygithub.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyesulee.mygithub.contract.UsersContract
import com.hyesulee.mygithub.databinding.ActivityMainBinding
import com.hyesulee.mygithub.model.Items
import com.hyesulee.mygithub.presenter.UsersPresenter

class MainActivity : AppCompatActivity(), UsersContract.View {
    private lateinit var binding: ActivityMainBinding
    private val presenter: UsersContract.Presenter = UsersPresenter(this)
    private lateinit var searchAdapter: SearchResultsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainSearchView.editText
            .setOnEditorActionListener { v, actionId, event ->
                binding.mainProgressBar.visibility = View.VISIBLE
                presenter.getUsers(binding.mainSearchView.editText.text.toString())

                binding.mainSearchBar.text = binding.mainSearchView.text
                binding.mainSearchView.hide()
                false
            }
    }

    override fun showUsers(result: ArrayList<Items>) {
        binding.mainProgressBar.visibility = View.GONE

        searchAdapter = SearchResultsAdapter(result)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.mainRecyclerView.adapter = searchAdapter
    }
}