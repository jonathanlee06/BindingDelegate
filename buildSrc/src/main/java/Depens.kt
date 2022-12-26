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

object AndroidConfig {
    const val applicationId = "com.jonathanlee.bindingdelegate.demo"
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "v1.0.0"
}

object LibraryConfig {
    const val groupId = "com.github.jonathanlee06"
    const val artifactId = "bindingDelegate"
    const val version = "1.0.0"
}

object Versions {
    const val gradle = "7.3.0"

    // Architectural Components
    const val activityKtx = "1.4.0"
    const val material = "1.5.0"
    const val navigation = "2.5.2"
    const val lifecycle = "2.5.1"

    // Kotlin
    const val kotlin = "1.6.10"

    // Unit Test
    const val junit = "4.13.2"
    const val androidxTest = "1.1.3"
    const val unitTestCore = "1.4.0"
    const val androidxTestRules = "1.2.0-alpha04"
    const val androidxCoreTesting = "2.1.0"
}

object Libraries {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"

    // Android
    const val appCompat = "androidx.appcompat:appcompat:1.6.0-rc01"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val coreKtx = "androidx.core:core-ktx:1.7.0"

    // Architectural Components
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    // Kotlin
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // Unit Test
    const val junit = "junit:junit:${Versions.junit}"
    const val androidxTest = "androidx.test.ext:junit:${Versions.androidxTest}"
    const val unitTestCore = "androidx.test:core:${Versions.unitTestCore}"
    const val androidxTestRules = "androidx.test:rules:${Versions.androidxTestRules}"
    const val androidxCoreTesting =
        "androidx.arch.core:core-testing:${Versions.androidxCoreTesting}"
}