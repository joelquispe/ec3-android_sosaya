package com.example.joel_sq.ModeloVista

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joel_sq.Configuracion.AppData.Companion.db
import com.example.joel_sq.Modelo.Proveedor
import com.example.joel_sq.databinding.ActivityFrmProveedorBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VistaProveedor:ViewModel(){
    val lista=MutableLiveData<List<Proveedor>?>()
    fun iniciar(){
        viewModelScope.launch {
            lista.value= withContext(Dispatchers.IO){
                db.daopersona().ListarProveedores()
            }
        }
    }
    ///----- Agregar Registros ---
    fun registrar(p: Proveedor){
        viewModelScope.launch {
            lista.value= withContext(Dispatchers.IO){
                db.daopersona().agregarproveedor(arrayListOf<Proveedor>(
                    p
                ))
                db.daopersona().ListarProveedores()
            }
        }
    }
    //----- Buscar por Apellidos
    fun buscarruc(cadena:String){
        viewModelScope.launch {
            lista.value= withContext(Dispatchers.IO){
                db.daopersona().buscarPorRuc(cadena)
            }
        }
    }


    //---Buscar por Codigo y Mostrar Registro
    fun buscarcodigo(cod:Long,b:ActivityFrmProveedorBinding){
        viewModelScope.launch {
            var contacto: Proveedor = withContext(Dispatchers.IO){
                db.daopersona().buscarcodigo(cod)
            }
            b.txtnroruc.setText(contacto.nroRuc.toString())
            b.txtrazonsocial.setText(contacto.razonSocial.toString())
            b.txtrubro.setText(contacto.rubro.toString())
            b.txtdireccion.setText(contacto.direccion.toString())
            b.txtcorreo.setText(contacto.correo.toString())
            b.txttelefono.setText(contacto.telefono.toString())
        }
    }

    ///----- Eliminar Registros ---

}