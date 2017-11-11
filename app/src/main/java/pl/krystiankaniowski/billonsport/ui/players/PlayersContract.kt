package pl.krystiankaniowski.billonsport.ui.players

import pl.krystiankaniowski.billonsport.mvp.BaseListContract

interface PlayersContract {

	data class Player(val id: String, val name: String) : BaseListContract.ListItem

	interface View : BaseListContract.View<Player>

	interface Presenter : BaseListContract.Presenter<View>

}