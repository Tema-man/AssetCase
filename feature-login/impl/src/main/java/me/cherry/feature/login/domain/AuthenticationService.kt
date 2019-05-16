package me.cherry.feature.login.domain

import androidx.annotation.WorkerThread
import me.cherry.feature.login.Configurator
import me.cherry.feature.login.LoginException
import me.cherry.feature.login.data.LoginResult

class AuthenticationService(
    private val configurator: Configurator
) {

  private var attempts: Int = 0
  private var nextAvailableAttemptTime: Long = 0

  @WorkerThread
  fun authenticate(
      login: String,
      password: String
  ): LoginResult {
    if (!hasAvailableAttempts()) {
      startCountdown()
      return LoginResult.Failed(LoginException.AttemptsExceeded)
    }

    if (login.isBlank()) return LoginResult.Failed(LoginException.WrongLogin)
    if (password.isBlank()) return LoginResult.Failed(LoginException.WrongPassword)
    if (login == password) {
      Thread.sleep(2000)
      return LoginResult.Successful(
          Profile(
              name = "user",
              photoUrl = "",
              email = "usermail@post.com"
          )
      )
    }
    return LoginResult.Failed(LoginException.AccessDenied)
  }

  private fun hasAvailableAttempts(): Boolean {
    if (System.currentTimeMillis() == nextAvailableAttemptTime) attempts = 0
    attempts++
    return attempts < configurator.maxLoginAttemptsCount
  }

  private fun startCountdown() {
    nextAvailableAttemptTime = System.currentTimeMillis() + configurator.loginAttemptsDelayMills
  }
}