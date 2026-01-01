pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.5.2" apply false
        id("com.android.library") version "8.5.2" apply false
        id("org.jetbrains.kotlin.android") version "1.9.24" apply false
        id("org.jetbrains.kotlin.kapt") version "1.9.24" apply false
        id("com.google.dagger.hilt.android") version "2.51" apply false
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AvitoFeedPro"

include(":app")
include(":domain")
include(":data")
include(":ui")
