package pl.krystiankaniowski.billonsport.view.items

import pl.krystiankaniowski.billonsport.view.adapter.ViewType

class MessageItem private constructor(val title: String, val description: String?) : ViewType {

	override val viewType = ViewType.MESSAGE

	companion object {

		fun noData(title: String = "No data", description: String? = null): MessageItem = MessageItem(title, description)

		fun error(title: String = "Error", description: String? = null): MessageItem = MessageItem(title, description)

	}

}
