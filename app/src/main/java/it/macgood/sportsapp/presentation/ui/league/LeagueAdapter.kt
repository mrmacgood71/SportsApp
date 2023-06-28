package it.macgood.sportsapp.presentation.ui.league

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import it.macgood.sportsapp.databinding.ItemLeagueBinding
import it.macgood.domain.model.league.League

class LeagueAdapter : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<League>() {
        override fun areItemsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem.leagueKey == newItem.leagueKey
        }

        override fun areContentsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LeagueViewHolder(ItemLeagueBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val league = differ.currentList[position]
        with(holder) {
            binding.leagueNameTextView.text = league.leagueName
            binding.countyNameTextView.text = league.countryName
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class LeagueViewHolder(val binding: ItemLeagueBinding) : RecyclerView.ViewHolder(binding.root)
}