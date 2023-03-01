package com.hien.mykmm.android.ui

import com.hien.mykmm.Greeting

class GreetPresenter(val greeting: Greeting) {
    fun print() = greeting.greet()
}