package me.cherry.feature.login.view

import me.cherry.feature.login.LoginException
import me.cherry.feature.login.LoginException.Reason.ATTEMTPS_EXCEEDED
import me.cherry.feature.login.LoginFeatureApiImpl
import me.cherry.feature.login.domain.Profile
import me.cherry.feature.login.view.LoginContract.Interactor


class LoginInteractor : Interactor {

  private val injector = LoginFeatureApiImpl.getInjector()
  private var attempts: Int = 0

  override fun startLogin(
      login: String,
      password: String,
      success: (Profile) -> Unit,
      error: (LoginException) -> Unit
  ) {
    attempts++
    if (attempts > injector.configurator.attemptsCount) {
      error(LoginException(ATTEMTPS_EXCEEDED))
      attempts = 0
    }
  }
}