package sorisoft.co.kr.shoppingmall.Controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_products.*
import sorisoft.co.kr.shoppingmall.Adapters.ProductsAdapter
import sorisoft.co.kr.shoppingmall.R
import sorisoft.co.kr.shoppingmall.Services.DataService
import sorisoft.co.kr.shoppingmall.Util.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        val layoutManager = GridLayoutManager(this, 2)

        ProductsListView.layoutManager = layoutManager
        ProductsListView.adapter = adapter
    }
}
