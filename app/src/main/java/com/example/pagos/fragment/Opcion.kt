package com.example.pagos.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pagos.R
import com.example.rickandmorty.utils.navigateBack
import com.example.rickandmorty.utils.navigateTo


class Opcion : Fragment() {

    val args: OpcionArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_opcion, container, false)
        val view = inflate.rootView
        val continuar = view.findViewById(R.id.btnRealizar) as Button
        val ver = view.findViewById(R.id.btnVer) as Button
        val back = view.findViewById(R.id.btnVolver) as Button

        continuar.setOnClickListener {
            navigateTo(OpcionDirections.actionOpcionToResumenTrans(args.datos))
        }
        ver.setOnClickListener {
            navigateTo(OpcionDirections.actionOpcionToVisualizarPagos(args.datos))
        }
        back.setOnClickListener {
            navigateTo(OpcionDirections.actionOpcionToGenerarPagos())
        }
        return inflate

    }


}