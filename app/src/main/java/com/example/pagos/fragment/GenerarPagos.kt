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
            if (nombre != "" || correo != "" || numero != "" || fecha != "") {
                validarCard(numero)?.let {
                    navigateTo(
                        GenerarPagosDirections.actionGenerarPagosToOpcion(
                            Pagos(
                                it,
                                nombre,
                                correo,
                                numero,
                                fecha
                            )
                        )
                    )
                    Toast.makeText(requireContext(), "Bienvenido", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(requireContext(), "Por favor llene los campos", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    fun validarCard(numero: String): String? {
        val tarjeta = numero.toLong()

        if (tarjeta == 4005580000000040) {
            return "Rechazada"
        }
        if (tarjeta == 7000000027) {
            return "Autorizado"
        }
        if (tarjeta == 4111111111111111) {
            return "Rechazada"
        }
        if (tarjeta == 4212121212121214) {
            return "Pendiente"
        }
        if (tarjeta == 4666666666666669) {
            return "Pendiente"
        }
        if (tarjeta == 5424000000000015) {
            return "Autorizada"
        }
        if (tarjeta == 5406251000000008) {
            return "Autorizada"
        }
        if (tarjeta == 370000000000002) {
            return "Autorizada"
        }
        if (tarjeta == 36018623456787) {
            return "Autorizada"
        }
        if (tarjeta == 8130010000000000) {
            return "Autorizada"
        }
        if (tarjeta == 4027390000000006) {
            return "Autorizada"
        }
        if (tarjeta == 4215440000000001) {
            return "Declinada"
        }
        if (tarjeta == 5907120000000009) {
            return "Declinada"
        }
        if (tarjeta == 6372000000000007) {
            return "Declinada"
        }
        Toast.makeText(requireContext(), "No se encuentra en el rango", Toast.LENGTH_SHORT).show()
        return null

    }

}