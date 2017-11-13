package pl.krystiankaniowski.billonsport.view.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.view.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.view.adapter.ViewType
import pl.krystiankaniowski.billonsport.view.adapter.ViewTypeDelegatedAdapter
import pl.krystiankaniowski.billonsport.view.items.MessageItem

class DelegatedMessageAdapter : ViewTypeDelegatedAdapter {

	override val viewType: Int = ViewType.MESSAGE

	override fun onCreateViewHolder(viewGroup: ViewGroup): UniversalViewHolder<MessageItem> = ViewHolder(viewGroup, R.layout.list_message)

	override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, item: ViewType) {

		viewHolder as ViewHolder
		item as MessageItem

		viewHolder.bind(item)

	}

	class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<MessageItem>(viewGroup, layoutId) {

		@BindView(android.R.id.text1)
		lateinit var title: TextView

		@BindView(android.R.id.text2)
		lateinit var details: TextView

		override fun bind(type: MessageItem) {

			title.text = type.title

			if (type.description.isNotEmpty()) {
				details.visibility = View.VISIBLE
				details.text = type.description
			} else {
				details.visibility = View.GONE
			}

		}

	}

}