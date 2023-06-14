package com.hyesulee.mygithub.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyesulee.mygithub.R
import com.hyesulee.mygithub.databinding.ItemSearchResultBinding
import com.hyesulee.mygithub.model.Items

class SearchResultsAdapter(private val result: ArrayList<Items>): RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemSearchResultBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(result[position]) {
                binding.name.text = this.login

                Glide.with(itemView.context)
                    .load(this.avatarUrl)
                    .circleCrop()
                    .placeholder(R.drawable.placeholder)
                    .into(binding.avatarImageView)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("login", this.login)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount() = result.size
}