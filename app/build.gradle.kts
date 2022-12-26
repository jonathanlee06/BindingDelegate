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
    implementation("com.github.jonathanlee06:BindingDelegate:1.0.1")

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

    // Unit test
    testImplementation(Libraries.junit)
    testImplementation(Libraries.unitTestCore)
    testImplementation(Libraries.androidxCoreTesting)
    androidTestImplementation(Libraries.androidxTest)
    androidTestImplementation(Libraries.androidxTestRules)
}