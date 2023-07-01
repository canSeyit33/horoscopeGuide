package com.seyitcanbag.burcrehberiapp

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.seyitcanbag.burcrehberiapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.one_row_layout.view.imgSymbolId
import kotlinx.android.synthetic.main.one_row_layout.view.tvIdHoroscope
import kotlinx.android.synthetic.main.one_row_layout.view.tvIdHoroscopeHistory


class CustomArrayAdapter(var inComingContext: Context, resource:Int,textViewResourceId:Int, var horoscopeName: Array<String>,
                         var horoscopeHistory: Array<String>,var  image: Array<Int>) : ArrayAdapter<String>(
    inComingContext, resource, textViewResourceId, horoscopeName){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {//her bir satırı oluştururken tetiklenen metod

        var one_row = convertView
        var viewHolder:ViewHolder
        if (one_row == null){//Öğelerim ilk kez oluşturuluyorsa
            var inflater = LayoutInflater.from(inComingContext)
            one_row = inflater.inflate(R.layout.one_row_layout,parent,false)//Constrait layoutumuz bunun içinde
            //1.par: neyin ekleneceği, 2.par : nereye ekleneceği, 3.par : hemen eklensin mi
            //parent: one_orw_layout'umuzun ekleneceği yerdir ve burada bu listViewdir bunu Log.e yardımıyla bulabiliriz
            //ör : Log.e("MESSAGE", "parent : $parent")
            viewHolder = ViewHolder(one_row)
            one_row.tag = viewHolder

            Log.e("Seyit Can: ", horoscopeName[position])
        }else{
            viewHolder = one_row.getTag() as ViewHolder
        }
        viewHolder.imageView.setImageResource(image[position])
        viewHolder.name.setText(horoscopeName[position])
        viewHolder.history.setText(horoscopeHistory[position])
        Log.e("MESSAGE", "parent : $parent")


        return one_row!!

    }
    class ViewHolder(one_row_view: View){
        var imageView:ImageView
        var name:TextView
        var history:TextView

        init {
            this.imageView = one_row_view.imgSymbolId
            this.name = one_row_view.tvIdHoroscope
            this.history = one_row_view.tvIdHoroscopeHistory
        }
    }
}