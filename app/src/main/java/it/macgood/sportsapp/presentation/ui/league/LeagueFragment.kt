package it.macgood.sportsapp.presentation.ui.league

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import it.macgood.core.extension.viewBinding
import it.macgood.core.fragment.makeToast
import it.macgood.core.network.Resource
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.FragmentLeagueBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LeagueFragment : Fragment(R.layout.fragment_league) {

    private val binding by viewBinding<FragmentLeagueBinding>()

    private val leagueViewModel by viewModels<LeagueViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val leagueAdapter = LeagueAdapter()
            binding.leaguesRecyclerView.adapter = leagueAdapter

            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.CREATED) {
                    leagueViewModel.leagues.collect { response ->
                        when(response) {
                            is Resource.Success -> {
                                response.data?.let { list ->
                                    leagueAdapter.differ.submitList(list)
                                    binding.shimmerLayout.hideShimmer()
                                    binding.shimmerLayout.visibility = View.GONE
                                }
                            }
                            is Resource.Loading -> {  }
                            is Resource.Error -> {
                                binding.shimmerLayout.hideShimmer()
                                makeToast(response.message)
                            }
                        }

                    }
                }
            }
        }
    }

}