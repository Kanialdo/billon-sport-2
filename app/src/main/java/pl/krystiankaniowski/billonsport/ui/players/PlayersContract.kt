package pl.krystiankaniowski.billonsport.ui.players

import pl.krystiankaniowski.billonsport.mvp.BaseContract

interface PlayersContract {

	data class Player(val id: String, val name: String)

	interface View : BaseContract.View {

		fun showPlayers(players: List<Player>)

		fun showNoPlayers()

	}

	interface Presenter : BaseContract.Presenter<View>

}