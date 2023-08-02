
package ann.tutorials.myshop.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ann.tutorials.myshop.ui.MainActivity
import ann.tutorials.myshop.databinding.ProductdisplayBinding
import ann.tutorials.myshop.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter(var products: List<Product>): RecyclerView.Adapter<ProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductdisplayBinding.inflate(LayoutInflater.from(parent.context))
        return  ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var myproducts = products[position]

        holder.binding.apply {
            tvTitle.text = myproducts.title
            tvDescription.text = myproducts.description

            Picasso
                .get()
                .load(myproducts.thumbnail)
                .resize(250, 250)
                .centerCrop()
                .into(holder.binding.ivproduct)
        }

        holder.binding.cvProducts.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDetailsActivity::class.java)
            intent.putExtra("PRODUCT_ID", myproducts.id)
            holder.itemView.context.startActivity(intent)
        }





    }

    override fun getItemCount(): Int {
        return  products.size
    }
}


class ProductViewHolder(var binding: ProductdisplayBinding): RecyclerView.ViewHolder(binding.root)









