package me.cherry.feature.login.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_login.btnForgotPassword
import kotlinx.android.synthetic.main.fragment_login.btnLogin
import kotlinx.android.synthetic.main.fragment_login.etLogin
import kotlinx.android.synthetic.main.fragment_login.etPassword
import me.cherry.feature.login.LoginException
import me.cherry.feature.login.R

class LoginView(
    private val presenter: LoginFragment,
    inflater: LayoutInflater,
    container: ViewGroup?
) : LayoutContainer {

  override val containerView: View = inflater.inflate(R.layout.fragment_login, container, false)

  init {
    btnLogin.setOnClickListener {
      presenter.loginClicked(etLogin.text.toString(), etPassword.text.toString())
    }
  }

  fun showLoginError(error: LoginException) {
    Toast.makeText(containerView.context, error::class.java.simpleName, Toast.LENGTH_SHORT).show()
  }

  fun showLoginSuccess() {
    Toast.makeText(containerView.context, "Login success", Toast.LENGTH_SHORT).show()
  }

  fun showLoginProgress(){
    etLogin.isEnabled = false
    etPassword.isEnabled = false
    btnLogin.isEnabled = false
    btnForgotPassword.isEnabled = false
  }

  fun hideLoginProgress() {
    etLogin.isEnabled = true
    etPassword.isEnabled = true
    btnLogin.isEnabled = true
    btnForgotPassword.isEnabled = true
  }
}