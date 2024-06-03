package com.example.appciudades.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appciudades.databinding.DetailciudadLayoutBinding
import com.example.appciudades.ui.MyViewModel

class DetailCiudadFragmnet: Fragment() {

    private var _binding: DetailciudadLayoutBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailciudadLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       // binding.button2.setOnClickListener {
       //     viewModel.eliminaCiudad()
       // }
    }
}