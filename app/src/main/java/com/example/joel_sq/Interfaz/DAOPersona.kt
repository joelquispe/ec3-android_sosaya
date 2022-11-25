package com.example.joel_sq.Interfaz

import androidx.room.*
import com.example.joel_sq.Modelo.Proveedor


@Dao
interface DAOProveedor {
    @Query("Select * from Proveedor")
    fun ListarProveedores():List<Proveedor>

    @Query("Select * from Proveedor where nroRuc LIKE '%' || :cadena || '%' ")
    fun buscarPorRuc(cadena:String):List<Proveedor>



    @Query("Select * from Proveedor where id_proveedor = :cod ")
    fun buscarcodigo(cod:Long): Proveedor

    @Insert
    fun agregarproveedor(proveedors:List<Proveedor>):List<Long>

    @Delete
    fun eliminarproveedor(proveedor: Proveedor):Int

    @Update
    fun actualizarproveedor(proveedor: Proveedor):Int

}