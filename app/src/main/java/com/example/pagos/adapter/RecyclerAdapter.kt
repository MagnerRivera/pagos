package com.example.pagos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pagos.R
import com.example.pagos.data.Pagos

class RecyclerAdapterPago(val pagos: List<Pagos>) :
    RecyclerView.Adapter<RecyclerAdapterPago.PagoViewHolder>() {
    class PagoViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trans, parent, false)
        return PagoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagoViewHolder, position: Int) {
        val pago = pagos[position]
        val view = holder.itemView
        view.findViewById<TextView>(R.id.traerEstado).apply {
            text = pago.estado
        }
        view.findViewById<TextView>(R.id.traerNombre).apply {
            text = pago.nombre
        }
        view.findViewById<TextView>(R.id.traerCorreo).apply {
            text = pago.correo
        }
        view.findViewById<TextView>(R.id.traerTarjeta).apply {
            text = pago.numero
        }
    }

    override fun getItemCount(): Int {
        return pagos.size
    }
}