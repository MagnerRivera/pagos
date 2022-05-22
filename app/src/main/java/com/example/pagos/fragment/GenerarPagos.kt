package com.example.pagos.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pagos.R
import com.example.pagos.data.Pagos
import com.example.rickandmorty.utils.navigateTo

class GenerarPagos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_generar_pagos, container, false)
        val view = inflate.rootView
        val continuar = view.findViewById(R.id.btnContinuar) as Button
        continuar.setOnClickListener {
            val nombre = view.findViewById<EditText>(R.id.nombre).run {
                text.toString()
            }
            val correo = view.findViewById<EditText>(R.id.correo).run {
                text.toString()
            }
            val numero = view.findViewById<EditText>(R.id.numeroTarjeta).run {
                text.toString()
            }
            val fecha = view.findViewById<EditText>(R.id.fecha).run {
                text.toString()
            }
            validarCard(numero)?.let {
                navigateTo(GenerarPagosDirections.actionGenerarPagosToOpcion(Pagos(it, nombre, correo, numero, fecha)))
            }
        }
        return view
    }

    fun validarCard(numero: String): String? {
        val tarjeta = numero.toLong()

        if (tarjeta == 4005580000000040){
        return "Rechaza"
        }
        Toast.makeText(requireContext(), "No se encuentra en el rango", Toast.LENGTH_SHORT).show()
        return null

    }

}