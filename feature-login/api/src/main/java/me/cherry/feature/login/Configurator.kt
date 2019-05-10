package me.cherry.feature.login


interface Configurator {
  val apiHost: String
  val attemptsCount: Int
}