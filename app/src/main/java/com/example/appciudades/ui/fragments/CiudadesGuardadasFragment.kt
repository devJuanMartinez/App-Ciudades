package com.example.appciudades.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appciudades.data.models.Ciudades
import com.example.appciudades.databinding.CiudadesguardadasLayoutBinding
import com.example.appciudades.ui.MyViewModel
import com.example.appciudades.ui.adapters.CiudadesAdapter

class CiudadesGuardadasFragment : Fragment() {

    private var _binding: CiudadesguardadasLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CiudadesAdapter
    private val viewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CiudadesguardadasLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler1()
        viewModel.allCiudades.observe(viewLifecycleOwner, {
            adapter.updateList(it)
        })

    }

    private fun configRecycler1() {
        val layoutManager = LinearLayoutManager(requireContext())
        adapter = CiudadesAdapter(object : CiudadesAdapter.MyClick{
            override fun onCiudadClick(ciudades: Ciudades) {
                TODO("Not yet implemented")
            }
        })
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
    private fun configRecycler2() {
        val layoutManager = LinearLayoutManager(requireContext())
        adapter = CiudadesAdapter(object : CiudadesAdapter.MyClick{
            override fun onCiudadClick(ciudades: Ciudades) {
                TODO("Not yet implemented")
            }
        })
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
}