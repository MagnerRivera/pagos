package com.example.pagos.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pagos(
    val estado: String,
    val nombre: String,
    val correo: String,
    val numero: String,
    val fecha: String,
) : Parcelable