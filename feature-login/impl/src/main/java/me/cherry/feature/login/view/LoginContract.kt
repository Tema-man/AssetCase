package me.cherry.feature.login.view

import me.cherry.feature.login.LoginException
import me.cherry.feature.login.domain.Profile


interface LoginContract {

  interface Presenter {
    fun loginClicked()
  }

  interface View {
    fun showLoginError(error: LoginException)
    fun showLoginSuccess()
    fun getLogin(): String
    fun getPassword(): String
  }

  interface Interactor {
    fun startLogin(
        login: String, password: String,
        success: (Profile) -> Unit, error: (LoginException) -> Unit
    )
  }
}