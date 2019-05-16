package me.cherry.feature.login.view

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.cherry.feature.login.data.LoginResult
import me.cherry.feature.login.domain.AuthenticationService

class LoginInteractor(
    private val authService: AuthenticationService
) {

  suspend fun startLogin(
      login: String,
      password: String
  ): LoginResult = withContext(Dispatchers.IO) {
    authService.authenticate(login, password)
  }
}