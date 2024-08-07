package com.bhavesh.chatwiseassignment.ui.products_activity

import ProductsAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhavesh.chatwiseassignment.R
import com.bhavesh.chatwiseassignment.databinding.ActivityProductsBinding
import com.bhavesh.chatwiseassignment.ui.product_detail_activity.ProductDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private val viewModel: ProductViewModel by viewModels()
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the adapter with an empty list initially
        productsAdapter = ProductsAdapter(emptyList()) {}

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ProductsActivity)
            adapter = productsAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                if (state.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.GONE
                    if (state.data.isNotEmpty()) {
                        // Update the adapter with the new data
                        productsAdapter = ProductsAdapter(state.data) { product ->
                            val intent = Intent(this@ProductsActivity, ProductDetailActivity::class.java).apply {
                                putExtra("productDetail", product)
                            }
                            startActivity(intent)
                        }
                        binding.recyclerView.adapter = productsAdapter
                    } else {
                        Toast.makeText(this@ProductsActivity, state.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
