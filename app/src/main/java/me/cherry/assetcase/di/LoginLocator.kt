package me.cherry.assetcase.di

import me.cherry.feature.login.Configurator
import me.cherry.feature.login.LoginDependencies


class LoginLocator(
  override val configurator: Configurator
) : LoginDependencies