package com.jonathanlee.bindingdelegate.ext

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.jonathanlee.bindingdelegate.base.ActivityDelegate

inline fun <reified T : ViewBinding> Activity.viewBinding() = ActivityDelegate(T::class.java)
inline fun <reified T : ViewBinding> Activity.viewBinding(
    crossinline bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T,
    isSetContent: Boolean = true,
    viewGroup: ViewGroup? = null,
    attach: Boolean = false,
) = lazy {
    val invoke = bindingInflater.invoke(layoutInflater, viewGroup, attach)
    if (isSetContent) setContentView(invoke.root)
    invoke
}