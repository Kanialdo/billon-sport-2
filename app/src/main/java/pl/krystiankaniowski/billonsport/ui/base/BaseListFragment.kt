package pl.krystiankaniowski.billonsport.ui.base

import pl.krystiankaniowski.billonsport.mvp.BaseListContract

abstract class BaseListFragment<in Type : BaseListContract.ListItem> : BaseFragment(), BaseListContract.View<Type> {

	override fun showLoading() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun showItems(items: List<Type>) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun showNoData() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun showLoadingError(message: String) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

}