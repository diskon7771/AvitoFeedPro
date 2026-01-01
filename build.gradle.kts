
plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "ru.avito.feedpro"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.avito.feedpro"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data-ai"))
    implementation(project(":data-photo"))
    implementation(project(":data-storage"))
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.compose.ui:ui:1.7.5")
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.navigation:navigation-compose:2.8.5")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("io.coil-kt:coil-compose:2.7.0")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")
}
