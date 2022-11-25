package com.example.joel_sq.Modelo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Proveedor(
    @PrimaryKey(autoGenerate = true)
    var id_proveedor:Long,
    var nroRuc:String,
    var razonSocial:String,
    var rubro:String,
    var direccion:String,
    var correo:String,
    var telefono:String
)
