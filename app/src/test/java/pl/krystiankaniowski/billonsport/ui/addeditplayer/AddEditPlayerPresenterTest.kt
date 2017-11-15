package pl.krystiankaniowski.billonsport.ui.addeditplayer

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import pl.krystiankaniowski.billonsport.model.Hash
import pl.krystiankaniowski.billonsport.repo.PlayersProvider

class AddEditPlayerPresenterTest {

	@Mock
	private val view: AddEditPlayerContract.View = Mockito.mock(AddEditPlayerContract.View::class.java)

	@Mock
	private val playersProvider: PlayersProvider = Mockito.mock(PlayersProvider::class.java)

	@Test
	fun saveValidatingNotExistingPlayer() {
		val instance = createAddInstance()
		instance.subscribe(view)
		instance.save("firstName", "lastName", "nickname")
		verify(playersProvider, times(1)).insert(any())
	}

	private fun createAddInstance(): AddEditPlayerPresenter {
		val kodein = Kodein {
			bind<PlayersProvider>() with singleton { playersProvider }
		}
		return AddEditPlayerPresenter(kodein)
	}

	private fun createEditInstance(): AddEditPlayerPresenter {
		val kodein = Kodein {
			bind<PlayersProvider>() with singleton { playersProvider }
			bind<Hash>() with singleton { Hash.create() }
		}
		return AddEditPlayerPresenter(kodein)
	}

}