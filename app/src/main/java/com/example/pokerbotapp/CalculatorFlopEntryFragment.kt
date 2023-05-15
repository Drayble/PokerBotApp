package com.example.pokerbotapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pokerbotapp.databinding.FragmentCalculatorFlopEntryBinding



class CalculatorFlopEntryFragment : Fragment() {

    private var _binding : FragmentCalculatorFlopEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorFlopEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        //sets & updates card images
        binding.imgbutton1.setImageResource(viewModel.flopCardOneImgRsc)
        binding.imgbutton2.setImageResource(viewModel.flopCardTwoImgRsc)
        binding.imgbutton3.setImageResource(viewModel.flopCardThreeImgRsc)
        binding.imgbutton4.setImageResource(viewModel.flopCardFourImgRsc)
        binding.imgbutton5.setImageResource(viewModel.flopCardFiveImgRsc)

        //only accessible on first pass
        binding.imgbutton1.setOnClickListener{
            if (viewModel.flopPass == 1) {

            }
        }
        binding.imgbutton1.setOnClickListener{
            if (viewModel.flopPass == 1) {

            }
        }
        binding.imgbutton1.setOnClickListener{
            if (viewModel.flopPass == 1) {

            }
        }
        //only accessible on second pass
        binding.imgbutton1.setOnClickListener{
            if (viewModel.flopPass == 2) {

            }
        }
        //only accessible on third pass
        binding.imgbutton1.setOnClickListener{
            if (viewModel.flopPass == 3) {

            }
        }


        binding.continueButton.setOnClickListener{
            viewModel.updateFlopPass()
        }


        return rootView
    }
}