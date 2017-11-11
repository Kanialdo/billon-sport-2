package pl.krystiankaniowski.billonsport.ui.matches

import pl.krystiankaniowski.billonsport.mvp.BaseListContract

interface MatchesContract {

	data class Match(val id: String, val name: String) : BaseListContract.ListItem

	interface View : BaseListContract.View<Match> {

	}

	interface Presenter : BaseListContract.Presenter<View>

}