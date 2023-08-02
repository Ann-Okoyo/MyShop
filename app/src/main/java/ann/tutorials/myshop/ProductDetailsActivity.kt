package ann.tutorials.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import ann.tutorials.myshop.R
import ann.tutorials.myshop.api.ApiClient
import ann.tutorials.myshop.api.ApiInterface
import ann.tutorials.myshop.databinding.ProductdisplayBinding
import ann.tutorials.myshop.model.Product
import com.squareup.picasso.Picasso
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProductDetailsActivity : AppCompatActivity() {
    lateinit var binding: ProductdisplayBinding
    lateinit var apiInterface: ApiInterface
    var productId = -1
    private var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductdisplayBinding.inflate(layoutInflater)



        setContentView(binding.root)

        apiInterface = ApiClient.buildClient(ApiInterface::class.java)

        val bundle = intent.extras
        if (bundle != null) {
            productId = bundle.getInt("PRODUCT_ID", -1)
        }



        fetchProductsDetails()

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun fetchProductsDetails() {
        GlobalScope.launch(Dispatchers.Main) {
            val response = apiInterface.getProductById(productId)

            if (response.isSuccessful){
                product = response.body()
                displayProductDetails()

            }
            else{
                Toast.makeText(this@ProductDetailsActivity, "Error, cannot fetch product details", Toast.LENGTH_LONG).show()
            }
        }
    }

           private fun displayProductDetails() {
                    product?.let {
                        binding.tvTitle.text = it.title
                        binding.tvDescription.text = it.description

                    Picasso
                        .get()
                        .load(it.thumbnail)
                        .resize(250, 250)
                        .centerCrop()
                        .into(binding.ivproduct)

                }


            }

        }


