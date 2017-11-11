package pl.krystiankaniowski.billonsport.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein
import pl.krystiankaniowski.billonsport.R

class MainActivity : AppCompatActivity(), KodeinInjected {

	override val injector = KodeinInjector()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		inject(appKodein())
	}

}
