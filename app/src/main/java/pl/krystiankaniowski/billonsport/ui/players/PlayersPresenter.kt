package pl.krystiankaniowski.billonsport.ui.players

class PlayersPresenter : PlayersContract.Presenter {

	private var view: PlayersContract.View? = null

	override fun subscribe(view: PlayersContract.View) {
		this.view = view
	}

	override fun unsubscribe() {
		view = null
	}

}