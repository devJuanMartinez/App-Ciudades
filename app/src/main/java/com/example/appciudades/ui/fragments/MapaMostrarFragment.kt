package com.example.appciudades.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.appciudades.R
import com.example.appciudades.databinding.MapaanidirBinding
import com.example.appciudades.databinding.MapamostrarLayoutBinding
import com.example.appciudades.ui.MyViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaMostrarFragment : Fragment(), OnMapReadyCallback {

    private var _binding: MapamostrarLayoutBinding? = null
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
        _binding = MapamostrarLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = (childFragmentManager.findFragmentById(R.id.map)) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_mapaMostrarFragment_to_mapaAniadirFragment)
        }

        viewModel.getCiudades().observe(viewLifecycleOwner){
            it.forEach {ciudad ->
                val options = MarkerOptions()
                    .position(LatLng(ciudad.latitud, ciudad.longitud))
                    .title(ciudad.nombre)

                val marker = mapa.addMarker(options)

            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        mapa = map

        /* TIPO DE MAPA */
        map.mapType = GoogleMap.MAP_TYPE_HYBRID
        /* Coger los Settings del mapa */
        val uiSettings = map.getUiSettings()
        /* Activar el control del zoom */
        uiSettings.isZoomControlsEnabled = true
    }
}