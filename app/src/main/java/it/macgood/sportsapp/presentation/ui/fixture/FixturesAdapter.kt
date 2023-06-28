package it.macgood.sportsapp.presentation.ui.fixture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.macgood.sportsapp.R
import it.macgood.sportsapp.databinding.ItemFixtureBinding
import it.macgood.domain.model.fixture.Fixture

typealias onItemClickListener = (ItemFixtureBinding) -> Unit

class FixturesAdapter(
    private val itemTransition: onItemClickListener
) : RecyclerView.Adapter<FixturesAdapter.FixtureViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Fixture>() {
        override fun areItemsTheSame(oldItem: Fixture, newItem: Fixture): Boolean {
            return oldItem.eventKey == newItem.eventKey
        }

        override fun areContentsTheSame(oldItem: Fixture, newItem: Fixture): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FixtureViewHolder(ItemFixtureBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        val fixture = differ.currentList[position]
        with(holder) {
            binding.homeTeamTextView.text = fixture.eventHomeTeam
            binding.awayTeamTextView.text = fixture.eventAwayTeam
            binding.eventDateTimeTextView.text = "${fixture.eventDate} ${fixture.eventTime}"
            binding.leagueTextView.text = fixture.leagueName

            if (fixture.eventStatus.isEmpty()) {
                binding.statusTextView.text = "Not started"
                binding.resultTextView.text = "- : -"
            } else {
                binding.statusTextView.text = fixture.eventStatus
                binding.resultTextView.text = fixture.eventFinalResult
            }

            if (fixture.scores != null) {
                val scores = fixture.scores
                try {
                    binding.quatersTextView.text = "Quaters: " +
                            "${scores.firstQuarter[0].scoreHome} : ${scores.firstQuarter[0].scoreAway}; " +
                            "${scores.secondQuarter[0].scoreHome} : ${scores.secondQuarter[0].scoreAway}; " +
                            "${scores.thirdQuarter[0].scoreHome} : ${scores.thirdQuarter[0].scoreAway}; " +
                            "${scores.fourthQuarter[0].scoreHome} : ${scores.fourthQuarter[0].scoreAway}; "
                } catch (e: IndexOutOfBoundsException) {
                    binding.quatersTextView.text = "Quaters: NOT FINISHED"
                }
            }

            Glide.with(itemView)
                .load(fixture.eventHomeTeamLogo)
                .error(R.drawable.ic_baseline_sports_basketball_24)
                .into(binding.homeTeamImageView)

            Glide.with(itemView)
                .load(fixture.eventAwayTeamLogo)
                .error(R.drawable.ic_baseline_sports_basketball_24)
                .into(binding.awayTeamImageView)

            itemView.setOnClickListener {
                itemView.findNavController()
                    .navigate(
                        R.id.action_contentFragment_to_webViewFragment,
                        bundleOf(
                            "url" to "https://google.com/search?q=${fixture.eventHomeTeam} ${fixture.eventAwayTeam}"
                        )
                    )
                itemTransition(binding)
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class FixtureViewHolder(val binding: ItemFixtureBinding) :
        RecyclerView.ViewHolder(binding.root)
}