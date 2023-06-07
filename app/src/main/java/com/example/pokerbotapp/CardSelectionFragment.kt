 package com.example.pokerbotapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pokerbotapp.databinding.FragmentCardSelectionBinding

class CardSelectionFragment : Fragment() {

    private var _binding : FragmentCardSelectionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCardSelectionBinding.inflate(inflater, container, false)
        val rootView = binding.root


        val cardButtonRows = mutableListOf<CardRow>()

        for (i in 1..13) {
            var src1 = viewModel.getImgSrc(i)
            var src2 = viewModel.getImgSrc(i+13)
            var src3 = viewModel.getImgSrc(i+26)
            var src4 = viewModel.getImgSrc(i+39)
            if (viewModel.cardIsTakenList[i]) {
                src1 = viewModel.getImgSrc(0)
            }
            if (viewModel.cardIsTakenList[i+13]) {
                src2 = viewModel.getImgSrc(0)
            }
            if (viewModel.cardIsTakenList[i+26]) {
                src3 = viewModel.getImgSrc(0)
            }
            if (viewModel.cardIsTakenList[i+39]) {
                src4 = viewModel.getImgSrc(0)
            }
            cardButtonRows.add(CardRow(
                CardButton(src1, i),
                CardButton(src2, i + 13),
                CardButton(src3, i + 26),
                CardButton(src4, i + 39)))
        }

        val mAdapter = CardRowItemAdapter(cardButtonRows, viewModel)
        binding.cardSelectionRecyclerView.adapter = mAdapter
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