package com.wright.beers20.commons

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wright.beers20.navigation.NavCommand
import com.wright.beers20.navigation.NavCommand.Back
import com.wright.beers20.navigation.NavCommand.BeerDetailsFragment
import com.wright.beers20.navigation.NavCommand.BeerListFragment

abstract class BaseFragment<VIEW_STATE : ViewState>(
    @LayoutRes layoutID: Int
) : Fragment(layoutID) {
    abstract val viewModel: BaseViewModel<VIEW_STATE>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewState()
        observeNavigation()
    }

    private fun observeNavigation() {
        viewModel.navCommand.observe(viewLifecycleOwner, ::handleNavigation)
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun observeViewState() {
        viewModel.viewState.observe(viewLifecycleOwner, ::renderViewState)
    }

    abstract fun renderViewState(newViewState: VIEW_STATE)

    private fun handleNavigation(navigation: NavCommand) {
        when (navigation) {
            Back -> findNavController().popBackStack()
            is BeerDetailsFragment -> findNavController().navigate(navigation.navigationId, bundleOf("beerId" to navigation.beerID))
            BeerListFragment -> findNavController().navigate(navigation.navigationId)
        }
    }

}
