package com.jonathanlee.bindingdelegate.base

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityDelegate<T : ViewBinding>(private val bindingClass: Class<T>) :
    ReadOnlyProperty<Activity, T> {

    // Init variable for binding the view
    private var binding: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        binding?.let { return it }

        // Inflate view class
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)

        // Bind the layout
        val invokeLayout = inflateMethod.invoke(null, thisRef.layoutInflater) as T

        // Set the content view
        thisRef.setContentView(invokeLayout.root)

        return invokeLayout.also { this.binding = it }
    }
}