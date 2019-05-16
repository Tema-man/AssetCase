package me.cherry.assetcase.di

import me.cherry.assetcase.App
import me.cherry.assetcase.AppConfiguratior
import me.cherry.feature.login.Configurator
import me.cherry.feature.login.LoginApi
import me.cherry.feature.login.LoginDependencies
import me.cherry.feature.login.di.LoginFeatureApiImpl


class Injector(
    val application: App
) {

  val configurator: Configurator by lazy { AppConfiguratior() }

  val loginLocator: LoginDependencies by lazy { LoginLocator(configurator) }

  val loginApi: LoginApi by lazy { LoginFeatureApiImpl(loginLocator) }

}