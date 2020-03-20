package sample.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_products_account.view.amountTextView
import kotlinx.android.synthetic.main.item_products_account.view.currencyTextView
import kotlinx.android.synthetic.main.item_products_account.view.labelTextView
import kotlinx.android.synthetic.main.item_products_account.view.panFourTextView
import kotlinx.android.synthetic.main.item_products_card.view.coverImageView
import sample.R
import sample.di.Injector
import sample.domain.model.Account
import sample.domain.model.Card
import sample.domain.model.Product
import sample.presentation.ProductsAdapter.ProductViewHolder

class ProductsAdapter(private val dataset: List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun getItemCount() = dataset.size

    override fun getItemViewType(position: Int) = when (dataset[position]) {
        is Account -> R.layout.item_products_account
        is Card -> R.layout.item_products_card
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.item_products_account -> AccountViewHolder(view)
            R.layout.item_products_card -> CardViewHolder(view)
            else -> null!!
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = dataset[position]
        when (holder) {
            is AccountViewHolder -> holder.init(product as Account)
            is CardViewHolder -> holder.init(product as Card)
        }
    }

    open class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    class AccountViewHolder(view: View) : ProductViewHolder(view) {
        fun init(account: Account) = with(view) {
            labelTextView.text = account.label
            panFourTextView.text = "·${account.pan4}"
            amountTextView.text = account.amount
            currencyTextView.text = account.currency
        }
    }

    class CardViewHolder(view: View) : ProductViewHolder(view) {

        private val imageLoader = Injector.provideImageLoader()

        fun init(card: Card) = with(view) {
            labelTextView.text = card.label
            panFourTextView.text = "·${card.pan4}"
            imageLoader.load(coverImageView, card.cover)
        }
    }

}