package pl.krystiankaniowski.billonsport.ui.players

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import pl.krystiankaniowski.billonsport.repo.PlayersProvider
import pl.krystiankaniowski.billonsport.ui.base.BasePresenter

class PlayersPresenter(kodein: Kodein) : BasePresenter<PlayersContract.View>(), PlayersContract.Presenter {

	private val playersProvider: PlayersProvider = kodein.instance()

	override fun onSubscribe() {
		requestData()
	}

	override fun onUnsubscribe() {
	}

	fun requestData() {

		val items = playersProvider.getAll()

		if (items.isNotEmpty()) {
			view?.showItems(items.map { PlayersContract.Player.convert(it) })
		} else {
			view?.showNoData()
		}

	}

}