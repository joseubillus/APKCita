package com.example.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apkpract1.R
import com.example.modelo.Paciente

class ADPPaciente: BaseAdapter {
    private lateinit var BD:ArrayList<Paciente>
    private val ct:Context

    constructor(c:Context){
        this.ct = c
    }

    constructor(c:Context, data:ArrayList<Paciente>){
        this.ct = c
        this.BD = data
    }

    fun getAdd(obj:Paciente){
        BD.add(obj)
    }

    override fun getCount(): Int {
        return BD.size
    }

    override fun getItem(position: Int): Paciente {
        return BD.get(position)
    }

    override fun getItemId(position: Int): Long {
        return BD.get(position).hashCode().toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var root = convertView
        if(convertView==null){
            root = LayoutInflater.from(ct)
                .inflate(R.layout.conf_paciente,parent,false)
        }
        var lblid:TextView = root!!.findViewById(R.id.FrmConfPac_lblid)
        var lblnom:TextView = root.findViewById(R.id.FrmConfPac_lblnom)
        var lblape:TextView = root.findViewById(R.id.FrmConfPac_lblape)
        var lbltel:TextView = root.findViewById(R.id.FrmConfPac_lbltelf)

        var pac = getItem(position)
        lblid.text = pac.getId
        lblnom.text = pac.getNom
        lblape.text = pac.getApe
        lbltel.text = pac.getTel.toString()
        return root
    }
}