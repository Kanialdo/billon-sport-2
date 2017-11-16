package pl.krystiankaniowski.billonsport.ui.addeditplayer

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.instanceOrNull
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.model.Hash
import pl.krystiankaniowski.billonsport.model.Player
import pl.krystiankaniowski.billonsport.repo.PlayersProvider
import pl.krystiankaniowski.billonsport.ui.base.BasePresenter
import pl.krystiankaniowski.billonsport.ui.utils.ViewData

class AddEditPlayerPresenter(kodein: Kodein) : BasePresenter<AddEditPlayerContract.View>(), AddEditPlayerContract.Presenter {

	private val playersProvider: PlayersProvider = kodein.instance()

	private var id: Hash? = kodein.instanceOrNull()

	override fun onSubscribe() {
	}

	override fun onUnsubscribe() {
	}

	override fun save(firstName: String, lastName: String, nickname: String) {

		if (id == null) {
			id = Hash.create()
		}

		playersProvider.insert(player)
			val player = Player(id!!, firstName, lastName, nickname)

	}

}