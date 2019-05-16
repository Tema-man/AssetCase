package me.cherry.feature.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import me.cherry.feature.login.data.LoginResult.Failed
import me.cherry.feature.login.data.LoginResult.Successful
import me.cherry.feature.login.di.LoginFeatureInjector

class LoginFragment : Fragment() {

  private lateinit var view: LoginView
  private lateinit var interactor: LoginInteractor

  private val uiScope = CoroutineScope(Dispatchers.Main)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    retainInstance = true
    val injector = LoginFeatureInjector
    interactor = LoginInteractor(
        injector.getAuthenticationService()
    )
  }

  override fun onDestroy() {
    super.onDestroy()
    uiScope.cancel()
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View? {
    view = LoginView(this, inflater, container)
    return view.containerView
  }

  fun loginClicked(login: String, password: String) {
    view.showLoginProgress()
    requestLogin(login, password)
  }

  private fun requestLogin(login: String, password: String) = uiScope.launch {
    when (val loginResult = interactor.startLogin(login, password)) {
      is Successful -> view.showLoginSuccess()
      is Failed     -> view.showLoginError(loginResult.error)
    }
    view.hideLoginProgress()
  }
}
