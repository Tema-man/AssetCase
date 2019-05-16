package me.cherry.assetcase

import me.cherry.feature.login.Configurator


class AppConfiguratior : Configurator {
  override val apiHost: String = ""
  override val maxLoginAttemptsCount: Int = 5
  override val loginAttemptsDelayMills: Long = 5000
}