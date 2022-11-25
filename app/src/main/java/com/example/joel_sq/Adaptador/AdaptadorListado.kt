package com.example.joel_sq.Adaptador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joel_sq.Modelo.Proveedor
import com.example.joel_sq.FrmProveedor

import com.example.joel_sq.R
import com.example.joel_sq.databinding.ListaBinding

class AdaptadorListado(private val data:List<Proveedor>?): RecyclerView.Adapter<AdaptadorListado.ViewHolder>() {
    class  ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var binding:ListaBinding=ListaBinding.bind(view)
        var contexto:Context = view.context
        fun enlazarDatos(p: Proveedor){
            binding.foto.setImageResource(R.drawable.ic_baseline_man_2_24)
            binding.txtcodigo.text="Código : "+p.id_proveedor.toString()
            binding.txtruc.text="Ruc : "+p.nroRuc
            binding.txtrazon.text="Razón social : "+p.razonSocial
            binding.txtrub.text="Rubro : "+p.rubro
            binding.root.setOnClickListener {
                val v= Intent(contexto,FrmProveedor::class.java)
                v.putExtra("op",2)
                v.putExtra("codigo",p.id_proveedor)
                contexto.startActivity(v)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //--Hacemos referencia al componente lista
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Proveedor?=data?.get(position)
        holder.enlazarDatos(item!!)
    }
    override fun getItemCount()=data!!.size
}