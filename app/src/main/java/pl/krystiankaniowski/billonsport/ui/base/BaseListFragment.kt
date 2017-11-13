package pl.krystiankaniowski.billonsport.ui.base

import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.view.adapter.UniversalAdapter
import pl.krystiankaniowski.billonsport.view.adapter.ViewType
import pl.krystiankaniowski.billonsport.view.items.LoadingItem
import pl.krystiankaniowski.billonsport.view.items.MessageItem

abstract class BaseListFragment<in Type : ViewType> : BaseFragment(), BaseListContract.View<Type> {

	protected val adapter = UniversalAdapter()

	override fun showLoading() {
		adapter.setData(listOf(LoadingItem()))
	}

	override fun showItems(items: List<Type>) {
		adapter.setData(items)
	}

	override fun showNoData() {
		adapter.setData(listOf(MessageItem.noData()))
	}

	override fun showLoadingError(message: String) {
		adapter.setData(listOf(MessageItem.error(message)))
	}

}