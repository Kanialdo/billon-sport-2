package pl.krystiankaniowski.billonsport

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kodein.*
import pl.krystiankaniowski.billonsport.model.Player
import pl.krystiankaniowski.billonsport.repo.PlayersProvider

class BillonSportApplication : Application(), KodeinAware {

	override val kodein by Kodein.lazy {

		bind<Context>() with instance(applicationContext)

		bind<PlayersProvider>() with singleton {
			object : PlayersProvider {
				override fun insert(item: Player) {}
				override fun get(id: String): Player? = null
				override fun getAll(): List<Player> = listOf()
			}
		}

	}

}