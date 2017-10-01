package sorisoft.co.kr.shoppingmall.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import sorisoft.co.kr.shoppingmall.Model.Category
import sorisoft.co.kr.shoppingmall.R

/**
 * Created by harry on 2017. 9. 28..
 */

//CategoryRecycleAdapter는 RecycleView의 adapter(viewHolder)를 상속받는다.

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemClick:(Category)->Unit): RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    //데이터의 위치와 홀더를 정의한다
    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    //개수를 반환
    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder{
        val view = LayoutInflater.from(context)
                .inflate(R.layout.category_list_item, parent, false) //root의 경우 parent로 그리고 attach root여부는 false
        return Holder(view,itemClick)
    }

    //사용할 holder class로 RecyclerView.ViewHolder와 안드로이드 view를 인자로 받는다.
    inner class Holder(itemView: View?, val itemClick:(Category)->Unit) : RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        //받은 인자를 view에서의 image와 title에 맵핑하여준다.
        fun bindCategory(category: Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title

            itemView.setOnClickListener{itemClick(category)}
        }

    }
}