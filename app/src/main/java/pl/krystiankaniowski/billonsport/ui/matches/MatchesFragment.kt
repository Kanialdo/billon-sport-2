package pl.krystiankaniowski.billonsport.ui.matches

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import pl.krystiankaniowski.billonsport.ui.base.BaseListFragment

class MatchesFragment : BaseListFragment<MatchesContract.Match>(), MatchesContract.View {

	override fun kodein(base: Kodein) = Kodein {
		extend(appKodein())
		bind<MatchesContract.Presenter>() with provider { MatchesPresenter() }
	}

	private val presenter: MatchesContract.Presenter by injector.instance()

	override fun subscribePresenter() {
		presenter.subscribe(this)
	}

	override fun unsubscribePresenter() {
		presenter.unsubscribe()
	}

}