package com.example.pokerbotapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokerbotapp.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    private var _binding : FragmentHelpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        val rootView = binding.root



        binding.pokerHandsWebsiteButton.setOnClickListener {
            openWebPage("https://en.wikipedia.org/wiki/List_of_poker_hands")
        }

        binding.gamblingHotlineButton.setOnClickListener {
            dialPhoneNumber("18004262537")
        }

        return rootView
    }


    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        activity?.startActivity(intent);
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        activity?.startActivity(intent);
    }

}