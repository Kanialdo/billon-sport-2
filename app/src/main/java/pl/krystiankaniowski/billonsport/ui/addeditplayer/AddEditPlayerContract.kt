package pl.krystiankaniowski.billonsport.ui.addeditplayer

import pl.krystiankaniowski.billonsport.mvp.BaseContract
import pl.krystiankaniowski.billonsport.ui.utils.ViewData

interface AddEditPlayerContract {

	interface View : BaseContract.View {

		fun setFirstName(firstName: ViewData<String>)

		fun setLastName(lastName: ViewData<String>)

		fun setNickname(nickname: ViewData<String>)

	}

	interface Presenter : BaseContract.Presenter<View> {

		fun save(firstName: String, lastName: String, nickname: String)

	}

}