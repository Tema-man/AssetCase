package me.cherry.feature.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.cherry.feature.login.view.LoginContract.Presenter

class LoginFragment : Fragment(), Presenter {

  private lateinit var view: LoginView
  private val interactor = LoginInteractor()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View? {
    view = LoginView(this, inflater, container)
    return view.containerView
  }

  override fun loginClicked() {
    interactor.startLogin(view.getLogin(), view.getPassword())
  }
}
