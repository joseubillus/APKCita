package com.example.apkpract1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.controlador.DUsuario

class MnLogin : AppCompatActivity() {
    private lateinit var txtusu: EditText
    private lateinit var txtpas:EditText
    private lateinit var btnacep:Button
    private lateinit var dusu:DUsuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mn_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtusu = findViewById(R.id.FrmLog_txtusu)
        txtpas = findViewById(R.id.FrmLog_txtpas)
        btnacep = findViewById(R.id.FrmLog_btnacep)
        btnacep.setOnClickListener(View.OnClickListener {
            val usu=txtusu.text.toString()
            val pas=txtpas.text.toString()
            dusu = DUsuario(this)
            dusu.getVal(usu,pas)
        })
    }
}