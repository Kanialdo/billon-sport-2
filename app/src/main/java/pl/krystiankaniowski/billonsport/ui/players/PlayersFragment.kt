package pl.krystiankaniowski.billonsport.ui.players

import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.appKodein

class PlayersFragment : Fragment(), PlayersContract.View, KodeinInjected {

	override val injector = KodeinInjector()

	private val presenter : PlayersContract.Presenter by injector.instance()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val kodein = Kodein {
			extend(appKodein())
			bind<PlayersContract.Presenter>() with provider { PlayersPresenter() }
		}

		injector.injector.inject(kodein)

	}

	override fun onResume() {
		super.onResume()
		presenter.subscribe(this)
	}

	override fun onPause() {
		presenter.unsubscribe()
		super.onPause()
	}

	override fun showPlayers(players: List<PlayersContract.Player>) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun showNoPlayers() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

}