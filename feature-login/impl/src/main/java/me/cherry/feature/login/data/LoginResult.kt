package me.cherry.feature.login.data

import me.cherry.feature.login.LoginException
import me.cherry.feature.login.domain.Profile

sealed class LoginResult {
  data class Successful(val profile: Profile) : LoginResult()
  data class Failed(val error: LoginException) : LoginResult()
}