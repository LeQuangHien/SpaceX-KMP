package com.hien.mykmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform