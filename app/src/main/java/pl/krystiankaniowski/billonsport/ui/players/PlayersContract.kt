package pl.krystiankaniowski.billonsport.ui.players

import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.view.adapter.ViewType

interface PlayersContract {

	class Player(val id: String, val name: String) : ViewType {

		companion object {

			val viewType = ViewType.autoId

			fun convert(player: pl.krystiankaniowski.billonsport.model.Player) = Player(player.id, "")

		}

		override val viewType: Int = Player.viewType

	}

	interface View : BaseListContract.View<Player>

	interface Presenter : BaseListContract.Presenter<View>

}