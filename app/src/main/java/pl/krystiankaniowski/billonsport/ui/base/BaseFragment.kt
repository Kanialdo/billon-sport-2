package pl.krystiankaniowski.billonsport.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein

abstract class BaseFragment : Fragment(), KodeinInjected {

	override val injector = KodeinInjector()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		injector.injector.inject(kodein(appKodein()))
	}

	override fun onResume() {
		super.onResume()
		subscribePresenter()
	}

	override fun onPause() {
		unsubscribePresenter()
		super.onPause()
	}

	protected abstract fun subscribePresenter()

	protected abstract fun unsubscribePresenter()

	protected abstract fun kodein(base: Kodein): Kodein

}