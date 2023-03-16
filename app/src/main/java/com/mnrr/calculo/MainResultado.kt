package com.mnrr.calculo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mnrr.calculo.R.id.*
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt

class MainResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_resultado)

        val mNombre= findViewById<TextView>(muestraNombre)
        val mPromedio= findViewById<TextView>(tVPromedio)
        val mDetalle= findViewById<TextView>(tVDetalle)
        val miBundle: Bundle?= this.intent.extras

        if (miBundle!= null){
            var nt1 = miBundle.getString("nota1")!!.toDouble()
            var nt2 = miBundle.getString("nota2")!!.toDouble()
            var nt3 = miBundle.getString("nota3")!!.toDouble()

            val promedio=((nt1+nt2+nt3)/3)

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            val roundoProm = df.format(promedio)

            mNombre.text=miBundle.getString("Nombre")
            mPromedio.text=roundoProm.toString()
            if (promedio>3.5){
                mDetalle.text="Gano"
                mDetalle.setTextColor(getResources().getColor(R.color.black));
            }else{
                mDetalle.text="Perdio"
            }

        }

        val btnAtras: Button = findViewById(btnAtras)
        btnAtras.setOnClickListener {salir()}
    }

    private fun salir(){
        finish()
    }
}