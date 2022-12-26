package com.jonathanlee.bindingdelegate.ext

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.jonathanlee.bindingdelegate.base.FragmentDelegate
import com.jonathanlee.bindingdelegate.base.FragmentDelegateByReflect

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    FragmentDelegateByReflect(T::class.java, this)

fun <T : ViewBinding> Fragment.viewBinding(viewBindingCreator: (View) -> T) =
    FragmentDelegate(this, viewBindingCreator)