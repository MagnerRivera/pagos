package com.example.pagos.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pagos.R
import com.example.rickandmorty.utils.navigateTo

class ResumenTrans : Fragment() {
    val args: ResumenTransArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resumen_trans, container, false)
        val datos = args.datos
        val back = view.findViewById(R.id.btn_cancelar) as Button
        view.findViewById<TextView>(R.id.traerEstado).apply {
            text = datos.estado
        }
        view.findViewById<TextView>(R.id.traerNombre).apply {
            text = datos.nombre
        }
        view.findViewById<TextView>(R.id.traerCorreo).apply {
            text = datos.correo
        }
        view.findViewById<TextView>(R.id.traerTarjeta).apply {
            text = datos.numero
        }
        view.findViewById<TextView>(R.id.traerFecha).apply {
            text = datos.fecha
        }
        back.setOnClickListener {
            navigateTo(ResumenTransDirections.actionResumenTransToOpcion(args.datos))
        }

        return view
    }

}