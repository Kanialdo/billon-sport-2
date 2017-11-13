package pl.krystiankaniowski.billonsport.ui.base

import android.os.Bundle
import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.view.adapter.UniversalAdapter
import pl.krystiankaniowski.billonsport.view.adapter.ViewType
import pl.krystiankaniowski.billonsport.view.adapter.delegates.DelegatedLoadingAdapter
import pl.krystiankaniowski.billonsport.view.adapter.delegates.DelegatedMessageAdapter
import pl.krystiankaniowski.billonsport.view.items.LoadingItem
import pl.krystiankaniowski.billonsport.view.items.MessageItem

abstract class BaseListFragment<in Type : ViewType> : BaseFragment(), BaseListContract.View<Type> {

	protected lateinit var adapter: UniversalAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val builder = UniversalAdapter.Builder()
				.register(DelegatedLoadingAdapter())
				.register(DelegatedMessageAdapter())

		adapter = createAdapter(builder).build()

	}

	open fun createAdapter(builder: UniversalAdapter.Builder) = builder

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