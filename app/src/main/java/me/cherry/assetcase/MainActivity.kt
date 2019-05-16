package me.cherry.assetcase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

  private lateinit var currentFragment: Fragment

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    supportFragmentManager.findFragmentById(R.id.container)?.let { fragment ->
      currentFragment = fragment
      return
    }

    val fragment = App.injector.loginApi.getLoginScreen()
    openFragment(fragment)
  }

  private fun openFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().run {
      currentFragment = fragment
      val tag = currentFragment::class.java.simpleName
      add(R.id.container, currentFragment, tag)
      commitAllowingStateLoss()
    }
  }
}
