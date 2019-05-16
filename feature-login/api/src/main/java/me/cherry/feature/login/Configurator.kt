package me.cherry.feature.login


interface Configurator {
  val apiHost: String
  val maxLoginAttemptsCount: Int
  val loginAttemptsDelayMills: Long
}