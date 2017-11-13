package pl.krystiankaniowski.billonsport.ui.players

import pl.krystiankaniowski.billonsport.ui.base.BasePresenter

class PlayersPresenter : BasePresenter<PlayersContract.View>(), PlayersContract.Presenter {

	override fun onSubscribe() {
		view?.showNoData()
	}

	override fun onUnsubscribe() {
	}

}