package me.cherry.feature.login.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_login.btnLogin
import me.cherry.feature.login.LoginException
import me.cherry.feature.login.R.layout
import me.cherry.feature.login.view.LoginContract.Presenter


class LoginView(
    private val presenter: Presenter,
    inflater: LayoutInflater,
    container: ViewGroup?
) : LayoutContainer, LoginContract.View {

  override val containerView: View = inflater.inflate(layout.fragment_login, container, false)

  init {
    btnLogin.setOnClickListener {
      presenter.loginClicked()
    }
  }

  override fun showLoginError(error: LoginException) {
    Toast.makeText(containerView.context, error.reason.name, Toast.LENGTH_SHORT).show()
  }

  override fun showLoginSuccess() {
    Toast.makeText(containerView.context, "Login success", Toast.LENGTH_SHORT).show()
  }
}