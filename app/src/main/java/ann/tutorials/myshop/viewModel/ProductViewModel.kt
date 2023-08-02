package ann.tutorials.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ann.tutorials.myshop.model.ProductResponse
import ann.tutorials.myshop.viewModel.repository.ProductRepository
import ann.tutorials.myshop.model.Product
import kotlinx.coroutines.launch
import retrofit2.Response

class ProductViewModel:ViewModel() {
    val productsRepo = ProductRepository()
    val productsLiveData= MutableLiveData<List<Product>>()
    val errLiveData = MutableLiveData<String>()


    fun fetchProducts(){
        viewModelScope.launch {
            val response = productsRepo.getProducts()
            if (response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }

    }


}





