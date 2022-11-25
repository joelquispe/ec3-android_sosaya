package com.example.joel_sq

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.joel_sq.Modelo.Proveedor
import com.example.joel_sq.ModeloVista.VistaProveedor
import com.example.joel_sq.databinding.ActivityFrmProveedorBinding

class FrmProveedor : AppCompatActivity() {

    lateinit var  b:ActivityFrmProveedorBinding
    lateinit var vistapersona: VistaProveedor
    var cod:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b=ActivityFrmProveedorBinding.inflate(layoutInflater)
        setContentView(b.root)
        var datos=intent.extras
        var op= datos?.getInt("op")?.toInt()
        b.btnguardar.visibility= View.INVISIBLE
        if (op==1){ //---Agregar un Registro
            b.btnguardar.visibility= View.VISIBLE
        }
        if(op==2){ //--- Leer Registro
            if (datos != null) {
                cod=datos.getLong("codigo").toLong()
            }
            vistapersona= ViewModelProvider(this).get()
            vistapersona.buscarcodigo(cod,b)
        }
        b.btnguardar.setOnClickListener {
            var p= Proveedor(0,b.txtnroruc.text.toString(),
                b.txtrubro.text.toString(),b.txtrubro.text.toString(),
                b.txtdireccion.text.toString(),b.txttelefono.text.toString(),
            b.txtcorreo.text.toString())

            vistapersona= ViewModelProvider(this).get()
            vistapersona.registrar(p)

            val v= Intent(this, MainActivity::class.java)
            v.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(v)
        }
    }
}