package com.mnrr.calculo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var cNombre : EditText? =null
    var cNota1 : EditText? =null
    var cNota2 : EditText? =null
    var cNota3 : EditText? =null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cNombre =findViewById(R.id.CampoNombre)
        cNota1 =findViewById(R.id.CampoNota1)
        cNota2 =findViewById(R.id.CampoNota2)
        cNota3 =findViewById(R.id.CampoNota3)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {onClick(1)}

    }
    private fun onClick(boton: Int) {
        when(boton){
            1->{
                val intent = Intent(this,MainResultado::class.java)
                val miBundle:Bundle=Bundle()
                miBundle.putString("Nombre",cNombre!!.text.toString())
                miBundle.putString("nota1", cNota1!!.text.toString())
                miBundle.putString("nota2", cNota2!!.text.toString())
                miBundle.putString("nota3", cNota3!!.text.toString())

                intent.putExtras(miBundle)

                startActivity(intent)
            }
        }
    }
}