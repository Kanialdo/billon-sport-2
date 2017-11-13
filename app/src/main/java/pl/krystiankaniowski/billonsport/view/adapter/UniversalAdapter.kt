package pl.krystiankaniowski.billonsport.view.adapter

import android.content.ContentValues.TAG
import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import pl.krystiankaniowski.billonsport.view.adapter.delegates.DelegatedLoadingAdapter

class UniversalAdapter(private var items: List<ViewType>? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private val delegatedAdapters = SparseArrayCompat<ViewTypeDelegatedAdapter>()

	init {
		delegatedAdapters.put(0, DelegatedLoadingAdapter())
	}

	fun registerDelegatedAdapter(adapter: ViewTypeDelegatedAdapter) {
		Log.v(TAG, "registering ${adapter.viewType} with $adapter")
		delegatedAdapters.put(adapter.viewType, adapter)
	}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

		val type = getItemViewType(position)
		val adapter = delegatedAdapters.get(type)
		val item = items?.get(position)

		if (item != null) {
			adapter.onBindViewHolder(holder, item)
		}

	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
		return delegatedAdapters.get(viewType).onCreateViewHolder(parent)
	}

	override fun getItemViewType(position: Int): Int {
		return items?.get(position)?.viewType ?: -1
	}

	override fun getItemCount(): Int {
		return items?.size ?: 0
	}

	fun setData(data: List<ViewType>) {
		items = data
	}

	class Builder {

		private val adapter: UniversalAdapter = UniversalAdapter()

		fun register(delegatedAdapter: ViewTypeDelegatedAdapter): Builder {
			this.adapter.registerDelegatedAdapter(delegatedAdapter)
			return this
		}

		fun build(): UniversalAdapter {
			return adapter
		}

	}

}