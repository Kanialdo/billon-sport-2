package pl.krystiankaniowski.billonsport.ui.matches

class MatchesPresenter : MatchesContract.Presenter {

	private var view: MatchesContract.View? = null

	override fun subscribe(view: MatchesContract.View) {
		this.view = view
	}

	override fun unsubscribe() {
		view = null
	}

}