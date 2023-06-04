package com.example.pokerbotapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pokerbotapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        viewModel.resetTheEntireViewModelForAllOfEternity()

        binding.calculatorModeButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCalculatorHandEntryFragment()
            rootView.findNavController().navigate(action)
        }

        binding.decisionModeButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToBotHandEntryFragment()
            rootView.findNavController().navigate(action)
        }

        setHasOptionsMenu(true)

        return rootView
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}