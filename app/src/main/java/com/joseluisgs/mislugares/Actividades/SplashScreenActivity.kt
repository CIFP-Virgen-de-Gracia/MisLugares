package com.joseluisgs.mislugares

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.joseluisgs.mislugares.Actividades.MainActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

/**
 * Actividad Splash
 * @property TIME Long
 */
class SplashActivityActivity : AppCompatActivity() {
    private val TIME: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Pantalla completa
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // Ocultamos los elementos que no queremos que salgan
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_splash_screen)

        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        val animacion3 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_lateral)

        splashTituloText.animation = animacion2
        splashVersionText.animation = animacion3
        splashImage.animation = animacion1

        //crea un intent para ir al activity main
        val main = Intent(this, MainActivity::class.java)

        Handler(Looper.getMainLooper()).postDelayed({
            run {
                startActivity(main)
                finish()
            }
        }, this.TIME)
    }
}