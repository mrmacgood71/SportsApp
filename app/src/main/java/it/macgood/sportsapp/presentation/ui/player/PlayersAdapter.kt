package it.macgood.sportsapp.presentation.ui.player

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.macgood.domain.model.league.League
import it.macgood.domain.model.player.Player
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.FragmentPlayersBinding
import it.macgood.sportsapp.databinding.ItemLeagueBinding
import it.macgood.sportsapp.databinding.ItemPlayerBinding

class PlayersAdapter : RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Player>() {
        override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem.playerKey == newItem.playerKey
        }

        override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlayerViewHolder(ItemPlayerBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = differ.currentList[position]
        with(holder) {
            binding.nameTextView.text = player.playerName
            binding.teamTextView.text = "Team: ${player.teamName}"
            binding.ageTextView.text = "Age: ${player.playerAge}"
            binding.goalsTextView.text = "Goals: ${player.playerGoals}"
            binding.matchesPlayedTextView.text = "Match played: ${player.playerMatchPlayed}"
            binding.typeTextView.text = "Position: ${player.playerType}"
            binding.numberTextView.text = "Number: ${player.playerNumber}"

            Glide.with(itemView)
                .load(player.playerImage)
                .error(R.drawable.ic_baseline_person_24)
                .into(binding.playerImageView)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class PlayerViewHolder (val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root)
}