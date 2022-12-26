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

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    buildFeatures.viewBinding = true
    compileSdk = AndroidConfig.compileSdk
    namespace = AndroidConfig.applicationId

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            applicationIdSuffix = ".dev"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

kapt {
    correctErrorTypes = true
}

dependencies {

    // BindingDelegate
    implementation("com.github.jonathanlee06:BindingDelegate:1.0.2")

    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)

    // androidx
    implementation(Libraries.activityKtx)

    // architectural components
    implementation(Libraries.lifecycleRuntimeKtx)
    implementation(Libraries.lifecycleJava8)
    implementation(Libraries.lifecycleLiveDataKtx)
    implementation(Libraries.navigationFragmentKtx)
    implementation(Libraries.navigationUiKtx)

    // Unit test
    testImplementation(Libraries.junit)
    testImplementation(Libraries.unitTestCore)
    testImplementation(Libraries.androidxCoreTesting)
    androidTestImplementation(Libraries.androidxTest)
    androidTestImplementation(Libraries.androidxTestRules)
}