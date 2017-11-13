package pl.krystiankaniowski.billonsport.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

interface ViewTypeDelegatedAdapter {

	val viewType : Int

	fun onCreateViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder

	fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, item: ViewType)

}