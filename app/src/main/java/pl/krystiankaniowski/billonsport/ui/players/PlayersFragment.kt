package pl.krystiankaniowski.billonsport.ui.players

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import pl.krystiankaniowski.billonsport.ui.base.BaseListFragment
import pl.krystiankaniowski.billonsport.view.adapter.UniversalAdapter

class PlayersFragment : BaseListFragment<PlayersContract.Player>(), PlayersContract.View {

	override fun kodein(base: Kodein): Kodein = Kodein {
		extend(appKodein())
		bind<PlayersContract.Presenter>() with provider { PlayersPresenter(this) }
	}

	private val presenter: PlayersContract.Presenter by injector.instance()

	override fun createAdapter(builder: UniversalAdapter.Builder): UniversalAdapter.Builder {
		return builder.register(PlayerDelegatedAdapter())
	}

	override fun subscribePresenter() {
		presenter.subscribe(this)
	}

	override fun unsubscribePresenter() {
		presenter.unsubscribe()
	}

}