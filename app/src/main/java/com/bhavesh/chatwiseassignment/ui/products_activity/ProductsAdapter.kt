import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bhavesh.chatwiseassignment.R
import com.bhavesh.chatwiseassignment.domain.model.Product
import com.bumptech.glide.Glide

class ProductsAdapter(
    private val items: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_TYPE_TITLE = 0
    private val ITEM_TYPE_PRODUCT = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE_TITLE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_title, parent, false)
                TitleViewHolder(view)
            }
            ITEM_TYPE_PRODUCT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_product, parent, false)
                ProductViewHolder(view, onItemClick)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                // Subtract 1 because the first item is the title
                val product = items[position - 1]
                holder.bind(product)
            }
        }
    }


    override fun getItemCount(): Int = items.size + 1 // +1 for the title item

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) ITEM_TYPE_TITLE else ITEM_TYPE_PRODUCT
    }

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class ProductViewHolder(
        itemView: View,
        private val onItemClick: (Product) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val productImageView: ImageView = itemView.findViewById(R.id.productImageView)

        init {
            itemView.setOnClickListener {
                // Ensure you have a valid product object
                val product = itemView.tag as? Product
                product?.let { onItemClick(it) }
            }
        }

        fun bind(product: Product) {
            nameTextView.text = product.name
            descriptionTextView.text = product.description
            Glide.with(itemView.context)
                .load(product.thumbnail)
                .into(productImageView)

            // Set the tag for itemView
            itemView.tag = product
        }
    }

}
