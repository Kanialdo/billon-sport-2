package pl.krystiankaniowski.billonsport.mvp

interface BaseContract {

	interface View

	interface Presenter<in V : View> {

		fun subscribe(view: V)

		fun unsubscribe()

	}

}