package pl.krystiankaniowski.billonsport

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kodein.*

class BillonSportApplication : Application(), KodeinAware {

	override val kodein by Kodein.lazy {
		bind<Context>() with instance(applicationContext)
	}

}