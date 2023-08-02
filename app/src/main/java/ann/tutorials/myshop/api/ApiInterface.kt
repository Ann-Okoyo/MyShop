package ann.tutorials.myshop.api

import ann.tutorials.myshop.model.Product
import ann.tutorials.myshop.model.ProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("/product")
    suspend fun getProducts():Response<ProductResponse>
    @GET("/product/{id}")
    suspend fun getProductById(@Path("id")productId:Int):Response<Product>


}