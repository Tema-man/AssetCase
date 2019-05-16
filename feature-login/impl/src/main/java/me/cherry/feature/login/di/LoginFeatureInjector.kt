package me.cherry.feature.login.di

import me.cherry.feature.login.Configurator
import me.cherry.feature.login.LoginDependencies
import me.cherry.feature.login.domain.AuthenticationService


object LoginFeatureInjector {

  private var dependencies: LoginDependencies? = null

  fun initGraph(dependencies: LoginDependencies) {
    this.dependencies = dependencies
  }

  fun clearGraph() {
    dependencies = null
  }

  fun getConfigurator(): Configurator =
      checkInitialized(dependencies?.configurator, Configurator::class.java.name)

  fun getAuthenticationService() = AuthenticationService(getConfigurator())

  private fun <T> checkInitialized(dependency: T?, name: String): T = dependency
      ?: throw IllegalStateException(" $name is not provided in LoginFeatureInjector")

}