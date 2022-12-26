/*
 *
 *
 *  * Designed and developed by 2022 Jonathan Lee
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.jonathanlee.bindingdelegate.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.jonathanlee.bindingdelegate.ext.observeWhenCreated
import com.jonathanlee.bindingdelegate.ext.observeWhenDestroyed
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentDelegateByReflect<T : ViewBinding>(
    bindingClass: Class<T>,
    private val fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    // Init variable for binding the view
    private var binding: T? = null

    // get the bind method from View class
    private val bindMethod = bindingClass.getMethod("bind", View::class.java)

    init {
        // Add observer to fragment's lifecycle
        fragment.lifecycle.observeWhenCreated {
            fragment.viewLifecycleOwnerLiveData.observe(fragment) {
                it.lifecycle.observeWhenDestroyed {
                    binding = null
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        binding?.let { return it }

        // Do checking on the fragment's lifecycle
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            error("Cannot access view bindings. View lifecycle is ${lifecycle.currentState}!")
        }

        // Bind the layout
        val invoke = bindMethod.invoke(null, thisRef.requireView()) as T

        return invoke.also { this.binding = it }
    }
}

class FragmentDelegate<T : ViewBinding>(
    private val fragment: Fragment,
    private val viewBindingCreator: (View) -> T
) : ReadOnlyProperty<Fragment, T> {

    // Init variable for binding the view
    private var binding: T? = null

    init {
        // Add observer to fragment's lifecycle
        fragment.lifecycle.observeWhenCreated {
            fragment.viewLifecycleOwnerLiveData.observe(fragment) {
                it.lifecycle.observeWhenDestroyed {
                    binding = null
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        binding?.let { return it }

        // Do checking on the fragment's lifecycle
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            error("Cannot access view bindings. View lifecycle is ${lifecycle.currentState}!")
        }

        return viewBindingCreator(thisRef.requireView()).also { this.binding = it }
    }
}