package it.macgood.sportsapp.presentation.ui.player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import it.macgood.core.extension.viewBinding
import it.macgood.core.fragment.makeToast
import it.macgood.core.network.Resource
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.FragmentPlayersBinding

@AndroidEntryPoint
class PlayersFragment : Fragment(R.layout.fragment_players) {

    private val binding by viewBinding<FragmentPlayersBinding>()

    private val playersViewModel by viewModels<PlayersViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PlayersAdapter()
        binding.playersRecyclerView.adapter = adapter

        binding.playersProgressBar.visibility = View.GONE

        playersViewModel.players.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let { players ->
                        adapter.differ.submitList(players)
                    }
                    binding.playersProgressBar.visibility = View.GONE
                    binding.noPlayersTextView.visibility = View.GONE
                }
                is Resource.Loading -> {
                    binding.playersProgressBar.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    makeToast(response.message)
                    binding.playersProgressBar.visibility = View.GONE
                }
            }
        }

        binding.searchButton.setOnClickListener {
            val playerName = binding.searchEditText.text?.toString()
            if (playerName != null && playerName.isNotEmpty()) {
                playersViewModel.getPlayers(playerName)
            }
        }
    }
}