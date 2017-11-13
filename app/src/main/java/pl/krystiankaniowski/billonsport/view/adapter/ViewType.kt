package pl.krystiankaniowski.billonsport.view.adapter

interface ViewType {

	val viewType: Int

	companion object {

		var autoId = 0
			get() {
				return field++
			}

		val LOADING = autoId
		val MESSAGE = autoId

	}

}