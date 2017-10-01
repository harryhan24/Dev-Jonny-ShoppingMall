package sorisoft.co.kr.shoppingmall.Services

import sorisoft.co.kr.shoppingmall.Model.Category
import sorisoft.co.kr.shoppingmall.Model.Product

/**
 * Created by harry on 2017. 9. 24..
 */
object DataService {
    val categories = listOf(
            Category("SHIRTS","shirtimage"),
            Category("HOODIES","hoodieimage"),
            Category("HATS","hatimage"),
            Category("DIGITAL","digitalgoodsimage")
    )

    var hoodies = listOf(
            Product("그래픽비니", "1000원", "hoodie1"),
            Product("그래픽비니", "1000원", "hoodie2"),
            Product("그래픽비니", "1000원", "hoodie3"),
            Product("그래픽비니", "1000원", "hoodie4")
    )
    var hats = listOf(
            Product("그래픽비니", "1000원", "hat1"),
            Product("검은모자", "1500원", "hat2"),
            Product("화이트모자", "2000원", "hat3"),
            Product("스냅백", "5500원", "hat4")
    )
    var shirts = listOf(
            Product("검은셔츠", "1000원", "shirt1"),
            Product("회색셔츠", "1500원", "shirt2"),
            Product("허슬셔츠", "2000원", "shirt3"),
            Product("키드플리 ", "5500원", "shirt4"),
            Product("스튜디오 ", "5900원", "shirt5")
    )

    val digitalGood = listOf<Product>()

    fun getProducts(category: String) : List<Product>{

        when(category){
            "SHIRTS" -> return shirts
            "HATS" -> return hats
            "HOODIES" -> return hoodies
            else -> return digitalGood
        }

    }
}