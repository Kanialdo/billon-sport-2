package pl.krystiankaniowski.billonsport.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein
import kotlinx.android.synthetic.main.activity_main.*
import pl.krystiankaniowski.billonsport.R

class MainActivity : AppCompatActivity(), KodeinInjected {

	override val injector = KodeinInjector()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		inject(appKodein())

		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

	}

	private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
		when (item.itemId) {
			R.id.navigation_players -> {
				message.setText(R.string.title_players)
				return@OnNavigationItemSelectedListener true
			}
			R.id.navigation_matches -> {
				message.setText(R.string.title_matches)
				return@OnNavigationItemSelectedListener true
			}
		}
		false
	}

}