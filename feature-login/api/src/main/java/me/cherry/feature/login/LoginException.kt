package me.cherry.feature.login


sealed class LoginException(val code: Int) : Exception() {
  object WrongPassword : LoginException(400)
  object WrongLogin : LoginException(401)
  object AccessDenied : LoginException(402)
  object AttemptsExceeded : LoginException(403)
}