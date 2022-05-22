package com.example.pagos

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pagos.data.APIConstants
import com.example.pagos.databinding.ActivityMainBinding
import com.example.pagos.utils.*
import com.example.rickandmorty.utils.animAppear
import com.example.rickandmorty.utils.animVanish
import com.google.common.hash.Hashing
import com.google.gson.Gson
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding
    val nonce = getRandom()
    val seed = getCurrentDateFormat()
    val nonceBase64 = getBase64(nonce.toByteArray())
    val tranKeyBase64 =
        getBase64(
            getSHA256(
                nonce + seed +
                        APIConstants.PlaceToPaytranKey
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        val generate = generate(APIConstants.PlaceToPaytranKey, "024h1IlD")
        val toJson = Gson().toJson(generate)
        val base64 = getBase64("1353026389707456367953844210510580641498".toByteArray())
        Log.e("TAG", "toJson $toJson")
        Log.e("TAG", "base64 $base64")
        initSplash()
    }


    /**
     * Metodo para el splash del inicio de aplicación
     */

    private fun initSplash() {
        Handler().postDelayed({
            biding.splash.root.animVanish(this, 1000)
            despuesinit()
        }, 1000)
    }

    /**
     * metodo para mostrar los parametros de la vista despues del splash
     */

    private fun despuesinit() {
        Handler().postDelayed({
            biding.fragmentContainer.animAppear(this, 3000)
        }, 1000)
    }
}