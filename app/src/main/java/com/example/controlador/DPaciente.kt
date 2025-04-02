package com.example.controlador

import android.content.Context
import android.widget.ListView
import android.widget.Toast
import com.example.modelo.Paciente
import com.example.util.ADPPaciente
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject

class DPaciente(var c:Context) {
    private var asyn:AsyncHttpClient = AsyncHttpClient()
    private var url:String = "http://172.56.1.82:8000/pacientes/";
    private var array:ArrayList<Paciente> = ArrayList()
    lateinit var lst:ListView

    fun getList(bus:String){
        asyn.get(url,null,object:AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int,headers: Array<out Header>?,
                                   responseBody: ByteArray?) {
                val resp = java.lang.String(responseBody).toString()
                getJSON(resp)
                lst.adapter = ADPPaciente(c,array)
            }
            override fun onFailure(statusCode: Int,headers: Array<out Header>?,
                                   responseBody: ByteArray?,error: Throwable?) {
                Toast.makeText(c,"Error:$error",Toast.LENGTH_LONG).show()
            }
        })
    }

    fun getJSON(resp:String){
        val json = JSONArray(resp)
        for (i in 0..json.length()-1) {
            val id = json.getJSONObject(i).getString("id")
            val nom = json.getJSONObject(i).getString("nom")
            val ape = json.getJSONObject(i).getString("ape")
            val tel:Int = json.getJSONObject(i).getString("tel").toInt()
            val img = json.getJSONObject(i).getString("img")
            array.add(Paciente(id,nom,ape,tel,img))
        }
        //Toast.makeText(c,"JSON:$nom",Toast.LENGTH_LONG).show()
    }
}