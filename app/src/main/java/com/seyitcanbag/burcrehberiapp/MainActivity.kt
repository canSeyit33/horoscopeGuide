package com.seyitcanbag.burcrehberiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.seyitcanbag.burcrehberiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var allHoroscopes:ArrayList<Horoscopes>
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataSources()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = resources.getColor(R.color.statusBar)

        var myAdapter = HoroscopeBaseAdapter(this, dataSources())
        binding.listViewId.adapter = myAdapter

        binding.listViewId.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this@MainActivity, Detail::class.java)
            intent.putExtra("itemClicked",position)
            intent.putExtra("allHoroscopes", allHoroscopes)
            startActivity(intent)
        }

    }

    fun dataSources(): ArrayList<Horoscopes>{
        allHoroscopes = ArrayList(12)

        var horoscope = resources.getStringArray(R.array.horoscope)
        var horoscopeHistory = resources.getStringArray(R.array.horoscopeHistory)
        var imageSymbols = arrayOf(R.drawable.koc1, R.drawable.boga2, R.drawable.ikizler3,
            R.drawable.yengec4, R.drawable.aslan5, R.drawable.basak6, R.drawable.terazi7,
            R.drawable.akrep8, R.drawable.yay9,R.drawable.oglak10, R.drawable.kova11,R.drawable.balik12)
        var imgBig:Array<Int> = arrayOf(R.drawable.koc_buyuk1, R.drawable.boga_buyuk2,
            R.drawable.ikizler_buyuk3, R.drawable.yengec_buyuk4, R.drawable.aslan_buyuk5,
            R.drawable.basak_buyuk6,R.drawable.terazi_buyuk7,R.drawable.akrep_buyuk8, R.drawable.yay_buyuk9,
            R.drawable.oglak_buyuk10,R.drawable.kova_buyuk11, R.drawable.balik_buyuk12)
        var generalFeatures = resources.getStringArray(R.array.horoscopeGeneralFeatures)

        for (i in 0..11){
            var temp = Horoscopes(horoscope[i],horoscopeHistory[i],imageSymbols[i],imgBig[i],generalFeatures[i])
            allHoroscopes.add(temp)
        }
        return allHoroscopes
    }
}