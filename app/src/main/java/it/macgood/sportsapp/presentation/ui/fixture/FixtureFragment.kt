package it.macgood.sportsapp.presentation.ui.fixture

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.transition.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint
import it.macgood.core.extension.viewBinding
import it.macgood.core.fragment.makeToast
import it.macgood.core.network.Resource
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.FragmentFixtureBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FixtureFragment : Fragment(R.layout.fragment_fixture) {

    private val binding by viewBinding<FragmentFixtureBinding>()

    private val fixtureViewModel by viewModels<FixtureViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fixturesAdapter = FixturesAdapter {
            exitTransition = MaterialElevationScale(false).apply {
                duration = 300
            }

            reenterTransition = MaterialElevationScale(true).apply {
                duration = 300
            }
        }

        binding.fixturesRecyclerView.adapter = fixturesAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                fixtureViewModel.fixtures.collect { response ->
                    when(response) {
                        is Resource.Success -> {

                            response.data?.let { list -> fixturesAdapter.differ.submitList(list) }
                            binding.shimmerLayout.hideShimmer()
                            binding.shimmerLayout.visibility = View.GONE
                        }
                        is Resource.Loading -> {

                        }
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