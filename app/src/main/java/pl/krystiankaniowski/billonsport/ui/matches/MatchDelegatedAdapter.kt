package pl.krystiankaniowski.billonsport.ui.matches

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.players.PlayersContract
import pl.krystiankaniowski.billonsport.view.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.view.adapter.ViewType
import pl.krystiankaniowski.billonsport.view.adapter.ViewTypeDelegatedAdapter

class MatchDelegatedAdapter : ViewTypeDelegatedAdapter {

	override val viewType: Int = PlayersContract.Player.viewType

	override fun onCreateViewHolder(viewGroup: ViewGroup): UniversalViewHolder<MatchesContract.Match> = ViewHolder(viewGroup, R.layout.list_player)

	override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, item: ViewType) {

		viewHolder as ViewHolder
		item as MatchesContract.Match

		viewHolder.bind(item)

	}

	class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<MatchesContract.Match>(viewGroup, layoutId) {

		@BindView(android.R.id.text1)
		lateinit var title: TextView

		override fun bind(type: MatchesContract.Match) {

			title.text = type.name

		}

	}

}