package pl.krystiankaniowski.billonsport.view.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.view.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.view.adapter.ViewType
import pl.krystiankaniowski.billonsport.view.adapter.ViewTypeDelegatedAdapter
import pl.krystiankaniowski.billonsport.view.items.LoadingItem

class DelegatedLoadingAdapter : ViewTypeDelegatedAdapter {

	override val viewType: Int = ViewType.LOADING

	override fun onCreateViewHolder(viewGroup: ViewGroup): UniversalViewHolder<LoadingItem> = ViewHolder(viewGroup, R.layout.list_loading)

	override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, item: ViewType) {

		viewHolder as ViewHolder
		item as LoadingItem

		viewHolder.bind(item)

	}

	class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<LoadingItem>(viewGroup, layoutId) {

		@BindView(android.R.id.text1)
		lateinit var message: TextView

		override fun bind(type: LoadingItem) {
			message.text = type.message
		}

	}

}

