package me.cherry.assetcase

import android.app.Application
import me.cherry.assetcase.di.Injector


class App : Application() {

  override fun onCreate() {
    super.onCreate()
    injector = Injector(this)
  }

  companion object{
    lateinit var injector: Injector
  }
}