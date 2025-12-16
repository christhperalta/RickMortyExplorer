pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Rick & Morty Explorer"
include(":app")

include(":home:api")
include(":home:impl")
include(":ui:ui")
include(":characters:api")
include(":characters:impl")
include(":episodes:api")
include(":episodes:impl")
include(":planets:api")
include(":planets:impl")
include(":missions:api")
include(":missions:impl")
include(":collection:api")
include(":collection:impl")
include(":profile:api")
include(":profile:impl")

include(":core:network")
include(":characters:data")
include(":characters:domain")
include(":episodes:domain")
include(":episodes:data")
