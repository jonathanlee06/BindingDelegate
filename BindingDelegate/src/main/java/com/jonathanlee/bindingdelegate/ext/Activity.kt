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