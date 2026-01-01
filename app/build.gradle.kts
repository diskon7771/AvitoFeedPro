plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.yourpackage.avito_feed_pro"  // ← замени на свой реальный namespace (обычно из AndroidManifest или старого файла)
    compileSdk = 35  // актуально на 2026, можно оставить 34 если был

    defaultConfig {
        applicationId = "com.yourpackage.avito_feed_pro"  // ← замени на свой
        minSdk = 24  // или твой текущий
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"  // ← последняя стабильная на январь 2026
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Compose BOM — синхронизирует все Compose-библиотеки на актуальные версии (Compose UI ~1.10.x, Material3 ~1.4.x и т.д.)
    implementation(platform("androidx.compose:compose-bom:2025.12.01"))

    // Основные Compose библиотеки (без версий — BOM подтянет)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose")
    implementation("androidx.navigation:navigation-compose")

    // Debug только tooling
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Твои остальные зависимости (актуальные версии из твоего списка)
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-compiler:2.51")

    // Модули проекта (Clean Architecture)
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":ui"))
    // если есть :src или другие — добавь аналогично

    // Тесты (если нужны)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2025.12.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}
