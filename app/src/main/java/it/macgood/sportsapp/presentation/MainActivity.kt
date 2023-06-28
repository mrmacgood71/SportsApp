package it.macgood.sportsapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint
import it.macgood.core.extension.viewBinding
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.ActivityMainBinding
import it.macgood.sportsapp.presentation.service.EXTRAS_NOTIFICATION_URL_KEY

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            setupNavController()
            setupNotificationNavigation()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun ActivityMainBinding.setupNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = navHostFragment.navController

        setSupportActionBar(toolbar.customToolbar)

        setupActionBarWithNavController(navController)
    }

    private fun setupNotificationNavigation() {
        val extras = intent.extras
        val url = extras?.getString(EXTRAS_NOTIFICATION_URL_KEY)
        if (extras != null) {
            navController.navigate(R.id.webViewFragment, bundleOf("url" to url))
        }
    }

    companion object {
        const val TAG = "TAG_SPORTS_APP"
    }

}