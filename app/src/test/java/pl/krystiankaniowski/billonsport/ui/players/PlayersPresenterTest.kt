package pl.krystiankaniowski.billonsport.ui.players

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import pl.krystiankaniowski.billonsport.model.Player
import pl.krystiankaniowski.billonsport.repo.PlayersProvider

class PlayersPresenterTest {

	@Mock
	private val view: PlayersContract.View = Mockito.mock(PlayersContract.View::class.java)

	@Mock
	private val playersProvider: PlayersProvider = Mockito.mock(PlayersProvider::class.java)

	private lateinit var instance: PlayersPresenter

	@Before
	fun init() {

		Mockito.`when`(playersProvider.getAll()).thenReturn(listOf(Player("1"), Player("2"), Player("3")))

		val kodein = Kodein {
			bind<PlayersProvider>() with singleton { playersProvider }
		}

		instance = PlayersPresenter(kodein)

	}

	@Test
	fun setItemsNotCalledWhneNoSubscription() {
		instance.requestData()
		verify(view, never()).showItems(any())
		verify(view, never()).showNoData()
	}

	@Test
	fun setItemsWhenDataFound() {
		instance.subscribe(view)
		verify(view, times(1)).showItems(any())
		verify(view, never()).showNoData()
	}

}