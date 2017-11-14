package pl.krystiankaniowski.billonsport.ui.base

import android.support.annotation.CallSuper
import pl.krystiankaniowski.billonsport.mvp.BaseContract

abstract class BasePresenter<View : BaseContract.View> : BaseContract.Presenter<View> {

	internal var view: View? = null

	@CallSuper
	override fun subscribe(view: View) {
		this.view = view
		onSubscribe()
	}

	@CallSuper
	override fun unsubscribe() {
		onUnsubscribe()
		view = null
	}

	abstract fun onSubscribe()

	abstract fun onUnsubscribe()

}

