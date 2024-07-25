plugins {
    id("java-library")
    id("kotlin")
    id("com.diffplug.spotless")
}

//NexusConfig.PUBLISH_ARTIFACT_ID = "konfetti-core"
//apply(from = "../../scripts/publish-module.gradle.kts")

spotless {
    kotlin {
        ktlint("1.1.0")
        target("src/**/*.kt")
    }
    java {
        removeUnusedImports()
        googleJavaFormat("1.15.0")
        target("**/*.java")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")//${Constants.kotlinVersion}")
//    testImplementation(libs.test.junit)
//    testImplementation(libs.test.mockito)
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:3.11.2")
}
