package pl.krystiankaniowski.billonsport.ui.matches

import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.ui.players.PlayersContract
import pl.krystiankaniowski.billonsport.view.adapter.ViewType

interface MatchesContract {

	data class Match(val id: String, val name: String) : ViewType {

		companion object {
			val viewType = ViewType.autoId
		}

		override val viewType: Int = PlayersContract.Player.viewType

	}

	interface View : BaseListContract.View<Match> {

	}

	interface Presenter : BaseListContract.Presenter<View>

}