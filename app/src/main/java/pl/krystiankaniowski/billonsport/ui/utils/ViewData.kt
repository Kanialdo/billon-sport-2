package pl.krystiankaniowski.billonsport.ui.utils

import android.widget.EditText

class ViewData<T> private constructor(val value: T, val errorMessageId: Int? = null) {

	companion object {

		fun <T> ok(value: T) = ViewData(value)
		fun <T> error(value: T, errorMessageId: Int) = ViewData(value, errorMessageId)

	}

}

fun EditText.setViewData(viewData: ViewData<String>) {

	this.setText(viewData.value)

	if (viewData.errorMessageId != null) {
		this.error = context.getString(viewData.errorMessageId)
	} else {
		this.error = null
	}

}