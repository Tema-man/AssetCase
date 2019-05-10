package me.cherry.feature.login


class LoginException(
    val reason: Reason
) : Exception() {

  enum class Reason {
    WRONG_PASSWORD,
    WRONG_LOGIN,
    ACCESS_DENIED,
    ATTEMTPS_EXCEEDED
  }
}