package pl.krystiankaniowski.billonsport.ui.matches

import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.appKodein

class MatchesFragment : Fragment(), MatchesContract.View, KodeinInjected {

	override val injector = KodeinInjector()

	private val presenter: MatchesContract.Presenter by injector.instance()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val kodein = Kodein {
			extend(appKodein())
			bind<MatchesContract.Presenter>() with provider { MatchesPresenter() }
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

	override fun showLoading() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun showItems(items: List<MatchesContract.Match>) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun showNoData() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun showLoadingError(message: String) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

}