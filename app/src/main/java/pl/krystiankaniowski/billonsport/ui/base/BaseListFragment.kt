package pl.krystiankaniowski.billonsport.ui.base

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.view.adapter.UniversalAdapter
import pl.krystiankaniowski.billonsport.view.adapter.ViewType
import pl.krystiankaniowski.billonsport.view.adapter.delegates.DelegatedLoadingAdapter
import pl.krystiankaniowski.billonsport.view.adapter.delegates.DelegatedMessageAdapter
import pl.krystiankaniowski.billonsport.view.items.LoadingItem
import pl.krystiankaniowski.billonsport.view.items.MessageItem

abstract class BaseListFragment<in Type : ViewType> : BaseFragment(), BaseListContract.View<Type> {

	protected lateinit var recyclerView: RecyclerView
	protected lateinit var adapter: UniversalAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val builder = UniversalAdapter.Builder()
				.register(DelegatedLoadingAdapter())
				.register(DelegatedMessageAdapter())

		adapter = createAdapter(builder).build()

	}

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

		val view = inflater?.inflate(R.layout.fragment_list, container, false)

		recyclerView = view?.findViewById(android.R.id.list)!!

		recyclerView.setHasFixedSize(true)
		recyclerView.adapter = adapter
		recyclerView.layoutManager = LinearLayoutManager(context)
		recyclerView.itemAnimator = DefaultItemAnimator()

		return view

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