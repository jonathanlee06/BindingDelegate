package com.jonathanlee.bindingdelegate.ext

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

internal fun Lifecycle.observeWhenDestroyed(destroyed: () -> Unit) {
    addObserver(LifecycleObserver(lifecycle = this, destroyed = destroyed))
}

internal fun Lifecycle.observeWhenCreated(create: () -> Unit) {
    addObserver(LifecycleObserver(lifecycle = this, create = create))
}

class LifecycleObserver(
    var lifecycle: Lifecycle?,
    var destroyed: (() -> Unit)? = null,
    var create: (() -> Unit)? = null
) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        create?.invoke()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        destroyed?.invoke()
        lifecycle?.apply {
            removeObserver(this@LifecycleObserver)
            lifecycle = null
        }
        create = null
        destroyed = null
    }
}