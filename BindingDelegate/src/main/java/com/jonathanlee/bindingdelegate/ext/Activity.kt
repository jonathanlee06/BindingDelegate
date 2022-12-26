package com.jonathanlee.bindingdelegate.ext

import android.app.Activity
import androidx.viewbinding.ViewBinding
import com.jonathanlee.bindingdelegate.base.ActivityDelegate

inline fun <reified T : ViewBinding> Activity.viewBinding() = ActivityDelegate(T::class.java)