package pl.krystiankaniowski.billonsport.mvp

import pl.krystiankaniowski.billonsport.view.adapter.ViewType

interface BaseListContract {

	interface View<in I : ViewType> : BaseContract.View {

		fun showLoading()

		fun showItems(items: List<I>)

		fun showNoData()

		fun showLoadingError(message: String)

	}

	interface Presenter<in V : View<*>> : BaseContract.Presenter<V> {

	}

}