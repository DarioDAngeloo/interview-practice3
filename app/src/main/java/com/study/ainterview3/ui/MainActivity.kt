package com.study.ainterview3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.study.ainterview3.R
import com.study.ainterview3.databinding.ActivityMainBinding
import com.study.ainterview3.domain.extensions.loadImageFromApi
import com.study.ainterview3.domain.model.Fox
import com.study.ainterview3.domain.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        initListeners()
    }

    private fun initListeners() {
        binding.btn.setOnClickListener {
            viewModel.getFox()
        }
    }

    private fun initObservers() {
        viewModel.foxData.observe(this){
            when(it){
                is Resource.Success -> it.data?.let { holderFox(it) }
                is Resource.Error -> bindError()
            }
        }
        viewModel.isLoading.observe(this){
            handleLoading(it)
        }
    }

    private fun bindError() {
        Toast.makeText(this, "error unknown", Toast.LENGTH_SHORT).show()
    }

    private fun handleLoading(isLoading : Boolean) {
        with(binding){
            if (isLoading) {
                progress.visibility = View.VISIBLE
            } else {
                progress.visibility  = View.GONE
                groupData.visibility= View.VISIBLE
                btn.visibility= View.VISIBLE
            }
        }
    }

    private fun holderFox(data : Fox) {
        with(binding){
            link.text = data.link
            img.loadImageFromApi(data.image)
        }
    }

}