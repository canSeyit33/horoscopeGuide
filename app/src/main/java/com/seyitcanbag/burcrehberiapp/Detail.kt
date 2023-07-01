package com.seyitcanbag.burcrehberiapp

import android.R
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.seyitcanbag.burcrehberiapp.databinding.ActivityDetailBinding


class Detail : AppCompatActivity() {

     lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var allHoroscopes = intent.extras?.get("allHoroscopes") as ArrayList<Horoscopes>
        var position = intent.extras?.get("itemClicked") as Int

        binding.tvHoroscopeFeatures.setText(allHoroscopes.get(position).generalFeatures)
        binding.header.setImageResource(allHoroscopes.get(position).imgBig)


        //toolbar = findViewById<View>(R.id.anim_toolbar) as Toolbar
        var toolbar = binding.animToolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        var collapsingToolbar = binding.collapsingToolbar
        collapsingToolbar.setTitle(allHoroscopes.get(position).horoscopeName)

        val header = binding.header

        var bitmap = BitmapFactory.decodeResource(resources, allHoroscopes.get(position).imgBig)
        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette?) {
                val vibrantColor = palette!!.getVibrantColor(R.attr.colorAccent)
                collapsingToolbar.setContentScrimColor(vibrantColor)
                window.statusBarColor = vibrantColor
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}