package pl.krystiankaniowski.billonsport.ui.addeditplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import kotlinx.android.synthetic.main.add_edit_player_fragment.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.base.BaseFragment
import pl.krystiankaniowski.billonsport.ui.utils.ViewData
import pl.krystiankaniowski.billonsport.ui.utils.setViewData

class AddEditPlayerFragment : BaseFragment(), AddEditPlayerContract.View {

	override fun kodein(base: Kodein) = Kodein {
		extend(appKodein())
		bind<AddEditPlayerContract.Presenter>() with provider { AddEditPlayerPresenter(this) }
	}

	private lateinit var unbinder: Unbinder
	private val presenter: AddEditPlayerContract.Presenter by injector.instance()

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val view = inflater?.inflate(R.layout.add_edit_player_fragment, container, false)!!
		unbinder = ButterKnife.bind(this, view)
		return view
	}

	override fun onDestroyView() {
		unbinder.unbind()
		super.onDestroyView()
	}

	override fun subscribePresenter() {
		presenter.subscribe(this)
	}

	override fun unsubscribePresenter() {
		presenter.unsubscribe()
	}

	override fun setFirstName(firstName: ViewData<String>) {
		et_first_name.setViewData(firstName)
	}

	override fun setLastName(lastName: ViewData<String>) {
		et_last_name.setViewData(lastName)
	}

	override fun setNickname(nickname: ViewData<String>) {
		et_nickname.setViewData(nickname)
	}

	@OnClick(R.id.b_save)
	internal fun clickSave() {
		presenter.save(et_first_name.text.toString(), et_last_name.text.toString(), et_nickname.text.toString())
	}

}