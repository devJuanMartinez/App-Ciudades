package com.example.appciudades.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.appciudades.data.models.Ciudades
import com.example.appciudades.data.room.AppDataBase

class Repositorio(context: Context) {

    val database = AppDataBase.getDatabase(context)
    val ciudadesDao= database.ciudadesDao()

    val allCiudades: LiveData<List<Ciudades>> = ciudadesDao.getAllCiudades()

    suspend fun insertaCiudad(ciudad: Ciudades) {
        ciudadesDao.insertaCiudad(ciudad)
    }

    suspend fun eliminaCiudad(ciudad: Ciudades) {
        ciudadesDao.eliminaCiudad(ciudad)
    }
}