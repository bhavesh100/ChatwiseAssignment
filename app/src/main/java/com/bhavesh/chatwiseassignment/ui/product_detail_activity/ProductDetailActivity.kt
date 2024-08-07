package com.bhavesh.chatwiseassignment.ui.product_detail_activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bhavesh.chatwiseassignment.R
import com.bhavesh.chatwiseassignment.databinding.ActivityProductDetailBinding
import com.bhavesh.chatwiseassignment.domain.model.Product
import com.bumptech.glide.Glide

//class ProductDetailActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_product_detail)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}
class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding

    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Assuming the product detail is passed through an Intent
        val productDetail: Product = intent.getParcelableExtra("productDetail")!!

//         Load the product image
        Glide.with(this)
            .load(productDetail.images.firstOrNull() ?: productDetail.thumbnail)
            .into(binding.productImageView)

        binding.productTitleTextView.text = productDetail.name
        binding.productDescriptionTextView.text = productDetail.description
        binding.productPriceTextView.text = getString(R.string.price_format, productDetail.price)
        binding.productRatingTextView.text = getString(R.string.rating_format, productDetail.rating)
        binding.productStockTextView.text = getString(R.string.stock_format, productDetail.stock)
//        binding.productBrandTextView.text = getString(R.string.brand_format, productDetail.brand)
        binding.productSkuTextView.text = getString(R.string.sku_format, productDetail.sku)
//        binding.productWeightTextView.text = getString(R.string.weight_format, productDetail.weight)
        binding.productDimensionsTextView.text = getString(R.string.dimensions_format,
            productDetail.dimensions.width, productDetail.dimensions.height, productDetail.dimensions.depth)
        binding.productWarrantyTextView.text = productDetail.warrantyInformation
        binding.productShippingTextView.text = productDetail.shippingInformation
        binding.productAvailabilityTextView.text = productDetail.availabilityStatus
        binding.productReturnPolicyTextView.text = productDetail.returnPolicy
    }
}
