package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }
    private fun initClickers() {
        with(binding) {
            btnRequest.setOnClickListener {
                viewModel.getLiveModel(firstnameEt.text.toString(), secondnameEt.text.toString())
                    .observe(viewLifecycleOwner, Observer { loveModel ->
                        Log.e("TAG", "initClickers: $loveModel")
                        val bundle = Bundle()
                        bundle.putSerializable("LoveModel", loveModel)
                        findNavController().navigate(R.id.secondFragment, bundle)
                    })
            }
        }
    }


}