package com.example.pagos.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagos.R
import com.example.pagos.adapter.RecyclerAdapterPago
import com.example.rickandmorty.utils.navigateTo

class VisualizarPagos : Fragment() {
    val args: VisualizarPagosArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val back = view?.findViewById(R.id.btn_cancelar) as Button
        val recyclerAdapterPago =
            RecyclerAdapterPago(listOf((args.datos)))
        val view = inflater.inflate(R.layout.fragment_visualizar_pagos, container, false)
        view.findViewById<RecyclerView>(R.id.reciclerPagos).apply {
            adapter = recyclerAdapterPago
            layoutManager = LinearLayoutManager(requireContext())
        }
        back.setOnClickListener {
            navigateTo(VisualizarPagosDirections.actionVisualizarPagosToOpcion(args.datos))
        }
        return view
    }
}