package me.cherry.feature.login.di

import androidx.fragment.app.Fragment
import me.cherry.feature.login.LoginApi
import me.cherry.feature.login.LoginDependencies
import me.cherry.feature.login.view.LoginFragment

class LoginFeatureApiImpl(
    dependencies: LoginDependencies
) : LoginApi {

  init {
    LoginFeatureInjector.initGraph(dependencies)
  }

  override fun getLoginScreen(): Fragment = LoginFragment()
}