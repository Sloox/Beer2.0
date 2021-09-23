package com.wright.beers20.presentation.screens.beerdetails

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.wright.beers20.R
import com.wright.beers20.commons.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerDetailsFragment : BaseFragment<BeerDetailsViewState>(R.layout.fragment_beer_details) {
    private val textViewName: TextView
        get() = requireView().findViewById(R.id.textview_name)

    override val viewModel: BeerDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onStartWithNavArguments(arguments?.getInt("beerId") ?: 0)
    }

    override fun renderViewState(newViewState: BeerDetailsViewState) {
        if (newViewState.beer.name.isNullOrBlank()) {
            textViewName.text = "Loading..."
        } else textViewName.text = newViewState.beer.name + " id: ${newViewState.beer.id}"
    }
}
