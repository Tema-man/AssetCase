package me.cherry.feature.login

import androidx.fragment.app.Fragment

interface LoginFeatureApi {
  fun getFragment(): Fragment
  fun setInjector(injector: LoginFeatureInjector)
}