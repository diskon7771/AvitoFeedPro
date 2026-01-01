pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.google.dagger.hilt.android" -> {
                    useModule("com.google.dagger:hilt-android-gradle-plugin:2.51")
                }
            }
        }
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
