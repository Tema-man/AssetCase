package me.cherry.assetcase.di

import me.cherry.assetcase.App
import me.cherry.feature.login.LoginFeatureApi
import me.cherry.feature.login.LoginFeatureApiImpl


object Injector {

  private lateinit var application: App

  fun initialize(app: App) {
    application = app
  }

  val loginFeatureApi: LoginFeatureApi = LoginFeatureApiImpl()
}