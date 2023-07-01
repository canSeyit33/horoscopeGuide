package com.seyitcanbag.burcrehberiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import com.seyitcanbag.burcrehberiapp.databinding.ActivityDetailBinding
import com.seyitcanbag.burcrehberiapp.databinding.ActivitySplashBinding
import me.ibrahimsn.particle.ParticleView

class SplashActivity : AppCompatActivity() {

    private lateinit var particleView: ParticleView


    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.logoImage.animation =
        var logoRotateAnimation = AnimationUtils.loadAnimation(this,R.anim.logorotate)
        binding.logoImage.animation = logoRotateAnimation

        particleView = findViewById(R.id.particleView)

    }

    override fun onResume() {
        super.onResume()
        particleView.resume()

        object: CountDownTimer(5000,1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                var intent = Intent(this@SplashActivity, MainActivity ::class.java)
                startActivity(intent)
            }

        }.start()


    }
    override fun onPause() {
        super.onPause()
        particleView.pause()
    }

}