package pl.krystiankaniowski.billonsport.ui.players

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.view.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.view.adapter.ViewType
import pl.krystiankaniowski.billonsport.view.adapter.ViewTypeDelegatedAdapter

class PlayerDelegatedAdapter : ViewTypeDelegatedAdapter {

	override val viewType: Int = PlayersContract.Player.viewType

	override fun onCreateViewHolder(viewGroup: ViewGroup): UniversalViewHolder<PlayersContract.Player> = ViewHolder(viewGroup, R.layout.list_player)

	override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, item: ViewType) {

		viewHolder as ViewHolder
		item as PlayersContract.Player

		viewHolder.bind(item)

	}

	class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<PlayersContract.Player>(viewGroup, layoutId) {

		@BindView(android.R.id.text1)
		lateinit var title: TextView

		override fun bind(type: PlayersContract.Player) {

			title.text = type.name

		}

	}

}