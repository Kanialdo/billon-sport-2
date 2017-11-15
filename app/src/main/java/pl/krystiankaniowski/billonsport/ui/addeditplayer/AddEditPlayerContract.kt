package pl.krystiankaniowski.billonsport.ui.addeditplayer

import pl.krystiankaniowski.billonsport.mvp.BaseContract

interface AddEditPlayerContract {

	interface View : BaseContract.View {

		fun setFirstName(firstName: String)

		fun setLastName(lastName: String)

		fun setNickname(nickname: String)

	}

	interface Presenter : BaseContract.Presenter<View> {

		fun save(firstName: String, lastName: String, nickname: String)

	}

}