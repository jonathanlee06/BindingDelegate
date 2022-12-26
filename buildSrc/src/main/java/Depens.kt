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