buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51")  // твоя текущая версия Hilt
    }
}

plugins {
    id("com.android.application") version "8.4.2" apply false
    id("com.android.library") version "8.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.25" apply false  // ← обновлено до 1.9.25
}
