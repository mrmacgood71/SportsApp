package it.macgood.sportsapp.presentation.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint
import it.macgood.core.extension.viewBinding
import it.macgood.core.network.Resource
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.FragmentSplashBinding
import it.macgood.sportsapp.presentation.ui.fixture.FixtureViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding<FragmentSplashBinding>()

    private val fixtureViewModel by viewModels<FixtureViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = MaterialElevationScale(false).apply {
            duration = 300
        }

        reenterTransition = MaterialElevationScale(true).apply {
            duration = 300
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                fixtureViewModel.fixtures.collect { response ->
                    when(response) {
                        is Resource.Success -> {
                            findNavController().navigate(R.id.action_splashFragment_to_contentFragment)
                        }
                        is Resource.Loading -> {}
                        is Resource.Error -> {findNavController().navigate(R.id.action_splashFragment_to_contentFragment)}
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }
}