package it.macgood.sportsapp.presentation.ui.webview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import it.macgood.core.extension.viewBinding
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.FragmentWebViewBinding

@AndroidEntryPoint
class WebViewFragment : Fragment(R.layout.fragment_web_view) {

    private val binding by viewBinding<FragmentWebViewBinding>()

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transformation = MaterialContainerTransform()
        transformation.interpolator = AnimationUtils.LINEAR_INTERPOLATOR
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(arguments?.getString("url") ?: "https://google.com/")
    }
    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }
}