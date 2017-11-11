package pl.krystiankaniowski.billonsport.mvp

interface BaseListContract {

	interface ListItem

	interface View<in I : ListItem> : BaseContract.View {

		fun showLoading()

		fun showItems(items: List<I>)

		fun showNoData()

		fun showLoadingError(message: String)

	}

	interface Presenter<in V : View<*>> : BaseContract.Presenter<V> {

	}

}