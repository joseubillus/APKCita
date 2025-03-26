package com.example.apkpract1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.controlador.DPaciente
import com.example.modelo.Paciente
import com.example.util.ADPPaciente

class MnPaciente : AppCompatActivity() {
    private lateinit var lstpac:ListView
    private lateinit var dpac:DPaciente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mn_paciente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lstpac = findViewById(R.id.FrmPac_lstpac)
        dpac = DPaciente(this)
        dpac.lst = lstpac
        dpac.getList("")
    }
}