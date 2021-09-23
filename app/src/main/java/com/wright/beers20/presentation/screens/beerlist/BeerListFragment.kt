package com.wright.beers20.presentation.screens.beerlist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.wright.beers20.R
import com.wright.beers20.commons.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerListFragment : BaseFragment<BeerListViewState>(R.layout.fragment_beer_list) {

    private val beerListTest: TextView
        get() = requireView().findViewById(R.id.text_list_test)
    private val beerButton: Button
        get() = requireView().findViewById(R.id.button_random_Beer)

    override val viewModel: BeerListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beerButton.setOnClickListener{
            viewModel.navigateRandomly()
        }
    }

    override fun renderViewState(newListViewState: BeerListViewState) {
        beerListTest.text = "beers received: ${newListViewState.beerList.size}"
    }
}
