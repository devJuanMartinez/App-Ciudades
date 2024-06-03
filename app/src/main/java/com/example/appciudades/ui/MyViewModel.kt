package com.example.appciudades.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appciudades.data.Repositorio
import com.example.appciudades.data.models.Ciudades
import kotlinx.coroutines.launch

class MyViewModel(val context: Context): ViewModel() {

    val repositorio = Repositorio(context)

    class MyViewModelFactory(val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java)
                .newInstance(context)
        }
    }

    val allCiudades = repositorio.allCiudades

    fun insertaCiudad (ciudad: Ciudades){
        viewModelScope.launch {
            repositorio.insertaCiudad(ciudad)
        }
    }

    fun eliminaCiudad(ciudad: Ciudades) {
        viewModelScope.launch {
            repositorio.eliminaCiudad(ciudad)
        }
    }

    val ciudadSeleccionada = MutableLiveData<Ciudades>()

    fun getCiudad(ciudad: Ciudades) {
        ciudadSeleccionada.value = ciudad
    }

    fun getCiudades() = repositorio.getCiudades()
}