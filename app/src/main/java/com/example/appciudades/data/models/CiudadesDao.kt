package com.example.appciudades.data.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CiudadesDao {
    @Query("SELECT * FROM InfoCiudades")
    fun getAllCiudades(): LiveData<List<Ciudades>>

    @Insert
    suspend fun insertaCiudad(vararg ciudad: Ciudades)

    @Delete
    suspend fun eliminaCiudad(ciudad: Ciudades)
}