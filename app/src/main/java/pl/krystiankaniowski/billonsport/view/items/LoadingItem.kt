package pl.krystiankaniowski.billonsport.view.items

import pl.krystiankaniowski.billonsport.view.adapter.ViewType

class LoadingItem(val message: String? = null) : ViewType {

	override val viewType: Int = ViewType.LOADING

}