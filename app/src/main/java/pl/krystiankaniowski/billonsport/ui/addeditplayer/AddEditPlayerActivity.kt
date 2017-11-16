package pl.krystiankaniowski.billonsport.ui.addeditplayer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.utils.ActivityUtils

class AddEditPlayerActivity : AppCompatActivity(), KodeinInjected {

	override val injector = KodeinInjector()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.add_edit_player_activity)
		inject(appKodein())

		var fragment: AddEditPlayerFragment? = supportFragmentManager
				.findFragmentById(R.id.frame) as AddEditPlayerFragment?

		if (fragment == null) {
			fragment = AddEditPlayerFragment()
			ActivityUtils.addFragmentToActivity(supportFragmentManager,
					fragment, R.id.frame)

		}

	}

}