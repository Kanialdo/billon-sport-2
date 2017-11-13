package pl.krystiankaniowski.billonsport.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class UniversalViewHolder<in Type : ViewType>(viewGroup: ViewGroup, layoutId: Int)
	: RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.context).inflate(layoutId, viewGroup, false)) {

	init {
		//ButterKnife.bind(this, itemView);
	}

	abstract fun bind(type: Type)

}
