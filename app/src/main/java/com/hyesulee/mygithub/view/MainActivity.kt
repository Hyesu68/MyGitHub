package com.hyesulee.mygithub.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hyesulee.mygithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainSearchView.editText
            .setOnEditorActionListener { v, actionId, event ->
                binding.mainSearchBar.text = binding.mainSearchView.text
                binding.mainSearchView.hide()
                false
            }
    }
}