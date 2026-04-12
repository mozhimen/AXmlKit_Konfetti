// Library modules
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://jitpack.io")
        gradlePluginPortal()
    }
}
include(
    ":xml",
    ":compose",
    ":core",
    ":samples:compose-kotlin",
    ":samples:xml-kotlin",
    ":samples:xml-java",
    ":samples:shared",
    ":xmlk_konfetti"
)
