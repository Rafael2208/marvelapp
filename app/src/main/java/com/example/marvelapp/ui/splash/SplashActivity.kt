package com.example.marvelapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.marvelapp.BaseActivity
import com.example.marvelapp.ui.mian.MainActivity

class SplashActivity : BaseActivity(){

    private val timeSleep: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configScreen()
        executionPause()
    }

    private fun configScreen(){
        //Ocultando a barra de navegação
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    private fun executionPause(){
        //Pausa na execução
        Handler().postDelayed({
            //Abrindo a tela principal
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }, timeSleep)

    }

    override fun onStop() {
        super.onStop()
        //Tirando a tela do empilhamento
        finishAffinity()
    }
}