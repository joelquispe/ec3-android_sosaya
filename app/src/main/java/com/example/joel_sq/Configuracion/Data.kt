package com.example.joel_sq.Configuracion

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.joel_sq.Interfaz.DAOProveedor
import com.example.joel_sq.Modelo.Proveedor


@Database(
    entities = [Proveedor::class],
    version = 3,
    exportSchema = false
)
abstract class Data:RoomDatabase() {
    abstract fun daopersona(): DAOProveedor
}