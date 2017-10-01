package sorisoft.co.kr.shoppingmall.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import sorisoft.co.kr.shoppingmall.Model.Category
import sorisoft.co.kr.shoppingmall.R




/**
 * Created by harry on 2017. 9. 28..
 */


/* adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,DataService.categories)에서
 * Adapter가  CategoryAdapter로 this와 DataService.categories를 맵핑하여준다*/

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View

        val holder: ViewHolder


        //컨텐츠뷰가 비어있을 경우에만 맵핑하여준다.
        //그렇지 않을경우 뷰를 볼때마다 계속 메서드를 가져오게되어 부하가 심해진다
        if(convertView == null){
            //xml레이아웃을 맵핑하여 주는 코드
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage) //전편에 만들었던 category_list.item.xml의 이미지 id를 categoryImage로 변경할 것
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            println("데이터 이니셜라이징 완료")
            //카테고리 태그에 데이터를 저장하여준다.
            categoryView.tag = holder
        }else{
            //이미 이니셜라이징이 된 경우
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }


        println("카테고리 데이터 맵핑중")

        //데이터를 가져온 후
        val category = categories[position]

        //데이터 연결시켜주기
        holder.categoryName?.text = category.title
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName) //각각 파일명, 파일이 있는 위치, 파일이 소속된 패키지명을 받아 구분자를 리턴함(리소스 네임)
        holder.categoryImage?.setImageResource(resourceId) //이미지 맵핑

        return categoryView
    }

    override fun getItem(position: Int): Any {
        //카테고리를 리턴
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        //사용하지 않을것임 유니크 id를 받아 처리하는 메서드
        return 0
    }

    override fun getCount(): Int {
        //전체 개수 반환 ios에서의 numberOfSection
        return categories.count()
    }

    private class ViewHolder{
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}
