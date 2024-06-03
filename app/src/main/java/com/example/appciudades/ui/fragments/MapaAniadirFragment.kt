package com.example.appciudades.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appciudades.R
import com.example.appciudades.data.models.Ciudades
import com.example.appciudades.databinding.MapaanidirBinding
import com.example.appciudades.ui.MyViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaAniadirFragment : Fragment(), OnMapReadyCallback {

    private var _binding: MapaanidirBinding? = null
    private val binding get() = _binding!!
    private lateinit var mapa: GoogleMap
    private val viewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MapaanidirBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = (childFragmentManager.findFragmentById(R.id.map)) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        mapa = map

        /* TIPO DE MAPA */
        map.mapType = GoogleMap.MAP_TYPE_HYBRID
        /* Coger los Settings del mapa */
        val uiSettings = map.getUiSettings()
        /* Activar el control del zoom */
        uiSettings.isZoomControlsEnabled = true

        val latLng = LatLng(38.38, -3.78)
        val cu = CameraUpdateFactory.newLatLng(latLng)
        val cuZoom = CameraUpdateFactory.newLatLngZoom(
            latLng,
            8f
        )
        map.moveCamera(cuZoom)




        map.setOnMapClickListener {location ->

            val latitud = location.latitude
            val longitud = location.longitude

            val options = MarkerOptions()
                .position(LatLng(latitud, longitud))
//                .title(nombre)
//                .snippet("Pulsa aquí para acceder")
//                .alpha(.6f)
//                .rotation(90f)
            val marker = map.addMarker(options)

            binding.button.setOnClickListener {
                val nombre = binding.nombreMarker.text.toString()
                val ciudadNueva = Ciudades(nombre, latitud, longitud)
                viewModel.insertaCiudad(ciudadNueva)
                binding.nombreMarker.setText("")
            }
        }


        map.setOnMarkerClickListener { marker ->
            if (marker == marker) {
                Toast.makeText(requireContext(), "adadad", Toast.LENGTH_SHORT).show()
            }

            map.setOnMarkerClickListener {
                if (it == marker) {
                    marker.remove()
                    true
                }
                false
            }

            false
        }

    }

}