package com.example.appciudades.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "InfoCiudades")
data class Ciudades(
    val nombre: String,
    val latitud: Double,
    val longitud: Double
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
