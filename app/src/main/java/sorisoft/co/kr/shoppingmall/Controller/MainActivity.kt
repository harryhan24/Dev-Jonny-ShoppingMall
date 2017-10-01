package sorisoft.co.kr.shoppingmall.Controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import sorisoft.co.kr.shoppingmall.Adapters.CategoryRecycleAdapter
import sorisoft.co.kr.shoppingmall.R
import sorisoft.co.kr.shoppingmall.Services.DataService
import sorisoft.co.kr.shoppingmall.Util.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //리스트뷰 인스턴스 생성
        adapter = CategoryRecycleAdapter(this,DataService.categories){ category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title) //data send
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)


    }
}
