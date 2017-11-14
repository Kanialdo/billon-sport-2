package pl.krystiankaniowski.billonsport.ui.base

import org.junit.Assert
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import pl.krystiankaniowski.billonsport.mvp.BaseContract

class BasePresenterTest {

	@Mock
	private val view: BaseContract.View = Mockito.mock(BaseContract.View::class.java)

	@Test
	fun viewExistAfterSubscription() {
		val presenter = createPresenter()
		presenter.subscribe(view)
		Assert.assertNotNull(presenter.view)
		presenter.unsubscribe()
	}

	@Test
	fun viewNotExistAfterUnSubscription() {
		val presenter = createPresenter()
		presenter.subscribe(view)
		presenter.unsubscribe()
		Assert.assertNull(presenter.view)
	}

	private fun createPresenter() = object : BasePresenter<BaseContract.View>() {
		override fun onSubscribe() {}
		override fun onUnsubscribe() {}
	}

}