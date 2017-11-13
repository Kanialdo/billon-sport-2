package pl.krystiankaniowski.billonsport.ui.matches

import pl.krystiankaniowski.billonsport.ui.base.BasePresenter

class MatchesPresenter : BasePresenter<MatchesContract.View>(), MatchesContract.Presenter {

	override fun onSubscribe() {
		view?.showNoData()
	}

	override fun onUnsubscribe() {
	}

}