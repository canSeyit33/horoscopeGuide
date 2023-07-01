package com.seyitcanbag.burcrehberiapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.one_row_layout.view.imgSymbolId
import kotlinx.android.synthetic.main.one_row_layout.view.tvIdHoroscope
import kotlinx.android.synthetic.main.one_row_layout.view.tvIdHoroscopeHistory
import kotlinx.coroutines.processNextEventInCurrentThread

class HoroscopeBaseAdapter(var context:Context, var allHoroscopes: ArrayList<Horoscopes>) : BaseAdapter() {

    /*var horoscope = context.resources.getStringArray(R.array.horoscope)
    var horoscopeHistory = context.resources.getStringArray(R.array.horoscopeHistory)
    var img:Array<Int> = arrayOf(R.drawable.koc1, R.drawable.boga2, R.drawable.ikizler3,
        R.drawable.yengec4, R.drawable.aslan5, R.drawable.basak6, R.drawable.terazi7,
        R.drawable.akrep8, R.drawable.yay9,R.drawable.oglak10, R.drawable.kova11,R.drawable.balik12)
    var imgBig:Array<Int> = arrayOf(R.drawable.koc_buyuk1, R.drawable.boga_buyuk2,
        R.drawable.ikizler_buyuk3, R.drawable.yengec_buyuk4, R.drawable.aslan_buyuk5,
        R.drawable.basak_buyuk6,R.drawable.terazi_buyuk7,R.drawable.akrep_buyuk8, R.drawable.yay_buyuk9,
        R.drawable.oglak_buyuk10,R.drawable.kova_buyuk11, R.drawable.balik_buyuk12)*/

    //var allHoroscope:ArrayList<Horoscope>

    override fun getCount(): Int {
        return allHoroscopes.size
    }

    override fun getItem(position: Int): Any {
        return allHoroscopes.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var one_row =convertView
        var viewHolder:ViewHolder
        if (one_row == null){
            val inflater = LayoutInflater.from(context)
            one_row = inflater.inflate(R.layout.one_row_layout,parent,false)
            viewHolder = ViewHolder(one_row)
            one_row.tag = viewHolder

        }else{
            viewHolder = one_row.getTag() as ViewHolder
        }

        viewHolder.name.setText(allHoroscopes[position].horoscopeName)
        viewHolder.history.setText(allHoroscopes[position].horoscopeHistory)
        viewHolder.pic.setImageResource(allHoroscopes[position].horoscopeImg)

        return one_row!!
    }
}
//data class Horoscope(var horoscopeName:String, var horoscopeHistory: String, var horoscopeImg:Int){}

class ViewHolder(one_row:View){
    val name:TextView
    val history:TextView
    val pic : ImageView

    init {
        this.name = one_row.tvIdHoroscope
        this.history = one_row.tvIdHoroscopeHistory
        this.pic = one_row.imgSymbolId
    }


}
