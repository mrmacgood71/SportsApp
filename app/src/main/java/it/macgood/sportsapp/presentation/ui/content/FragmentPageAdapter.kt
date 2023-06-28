package it.macgood.sportsapp.presentation.ui.content

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import it.macgood.sportsapp.presentation.ui.fixture.FixtureFragment
import it.macgood.sportsapp.presentation.ui.league.LeagueFragment
import it.macgood.sportsapp.presentation.ui.player.PlayersFragment

class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) FixtureFragment() else if (position == 1) LeagueFragment() else PlayersFragment()
    }
}