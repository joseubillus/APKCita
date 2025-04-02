package com.example.controlador

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.apkpract1.MnMenu
import com.example.util.Mensaje
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class DUsuario(val c:Context) {
    private var asyn: AsyncHttpClient = AsyncHttpClient()
    private var url:String = "http://172.56.1.82:8000/login/"
    private var ms:Mensaje = Mensaje(c)

    fun getVal(usu:String,pas:String){
        val jpara = JSONObject()
        jpara.put("id",0)
        jpara.put("nombre_usuario",usu)
        jpara.put("contrasena",pas)
        val entity = StringEntity(jpara.toString())
        asyn.post(c,url,entity,"application/json",object:AsyncHttpResponseHandler(){
            override fun onStart() {
                super.onStart()
                ms.MProgressBarDato()
            }
            override fun onSuccess(statusCode: Int,headers: Array<out Header>?,
                responseBody: ByteArray?) {
                ms.MCloseProgBar(true)
                val resp:String = java.lang.String(responseBody).toString()
                val json = JSONObject(resp).optString("mensaje")
                if(json.equals("Autorizado"))
                    c.startActivity(Intent(c,MnMenu::class.java))
                else Toast.makeText(c,"Resp:"+resp,Toast.LENGTH_LONG).show()
            }
            override fun onFailure(statusCode: Int,headers: Array<out Header>?,
                responseBody: ByteArray?,error: Throwable?) {
                ms.MCloseProgBar(true)
                if(responseBody!=null){
                    val resp = String(responseBody)
                    val json = JSONObject(resp)
                    val jerror = json.optString("detail","Error desconocido")
                    Toast.makeText(c,"Error:$jerror",Toast.LENGTH_LONG).show()
                }
                else Toast.makeText(c,"Error:"+error,Toast.LENGTH_LONG).show()
            }
        })
    }
}