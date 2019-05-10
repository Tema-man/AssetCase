package me.cherry.feature.login

import androidx.fragment.app.Fragment
import me.cherry.feature.login.view.LoginFragment

object LoginFeatureApiImpl : LoginFeatureApi {

  private var injector: LoginFeatureInjector? = null

  fun getInjector(): LoginFeatureInjector =
      checkNotNull(injector) { "LoginFeatureInjector must be provided before using login feature" }

  override fun setInjector(injector: LoginFeatureInjector) {
    this.injector = injector
  }

  override fun getFragment(): Fragment {
    getInjector()
    return LoginFragment()
  }
}