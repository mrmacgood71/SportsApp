package it.macgood.sportsapp.presentation.ui.content

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import it.macgood.core.extension.viewBinding
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.FragmentContentBinding

@AndroidEntryPoint
class ContentFragment : Fragment(R.layout.fragment_content) {

    private val binding by viewBinding<FragmentContentBinding>()


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            configTabs()
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

    private fun FragmentContentBinding.configTabs() {
        val adapter = FragmentPageAdapter(childFragmentManager, lifecycle)
        tabLayout.addTab(tabLayout.newTab().setText("Fixtures").setIcon(R.drawable.ic_baseline_sports_basketball_24))
        tabLayout.addTab(tabLayout.newTab().setText("Leagues").setIcon(R.drawable.ic_baseline_shield_24))
        tabLayout.addTab(tabLayout.newTab().setText("Players").setIcon(R.drawable.ic_baseline_person_24))
        viewPager.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}