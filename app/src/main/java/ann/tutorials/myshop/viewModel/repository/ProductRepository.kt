
//import ann.tutorials.myshop.api.ApiClient
//import ann.tutorials.myshop.api.ApiInterface
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import okhttp3.Dispatcher
//
//class ProductRepository {
//    val  apiClient =ApiClient.buildClient(ApiInterface::class.java)
//
//    suspend fun getProducts():Response<ProductRepository>{
//        return withContext(Dispatchers.10){
//            apiClient.getProducts()
//        }
//    }
//}
package ann.tutorials.myshop.viewModel.repository

import ann.tutorials.myshop.model.ProductResponse
import ann.tutorials.myshop.api.ApiClient
import ann.tutorials.myshop.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class ProductRepository {
//    make our api call
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getProducts(): Response<ProductResponse> {
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }
    }
}