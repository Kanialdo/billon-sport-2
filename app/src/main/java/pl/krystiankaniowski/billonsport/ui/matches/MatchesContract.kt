package pl.krystiankaniowski.billonsport.ui.matches

import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.view.adapter.ViewType

interface MatchesContract {

	data class Match(val id: String, val name: String) : ViewType {

		val ViewType.Companion.MATCH
			get() = autoId

		override val viewType: Int = ViewType.MATCH

	}

	interface View : BaseListContract.View<Match> {

	}

	interface Presenter : BaseListContract.Presenter<View>

}