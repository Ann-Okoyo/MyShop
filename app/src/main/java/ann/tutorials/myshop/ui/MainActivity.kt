package ann.tutorials.myshop.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ann.tutorials.myshop.model.Product
import ann.tutorials.myshop.model.ProductResponse
import ann.tutorials.myshop.api.ApiClient
import ann.tutorials.myshop.api.ApiInterface
//import androidx.recyclerview.widget.LinearLayoutManager
import ann.tutorials.myshop.databinding.ActivityMainBinding
import ann.tutorials.myshop.viewmodel.ProductViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val productViewModel: ProductViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    var products: List<Product> = emptyList()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        productViewModel.fetchProducts()

        productViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        })


        productViewModel.productsLiveData.observe(this, Observer { products ->
            val adapter = ProductAdapter(products?: emptyList())
            binding.rvproducts.adapter = adapter
            binding.rvproducts.layoutManager = GridLayoutManager(this@MainActivity, 2)
        })
    }

}






