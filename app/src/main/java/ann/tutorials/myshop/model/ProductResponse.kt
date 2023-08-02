package ann.tutorials.myshop.model

import ann.tutorials.myshop.model.Product

data class ProductResponse(
    var products:List<Product>,
    var total:Int,
    var skip:Int,
    var payment:Int,
)


