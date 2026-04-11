plugins {
    id("com.android.library")
    id("kotlin-android")
//    id("com.diffplug.spotless")
}

//NexusConfig.PUBLISH_ARTIFACT_ID = "konfetti-compose"
//apply(from = "../../scripts/publish-module.gradle.kts")

//spotless {
//    kotlin {
//        ktlint("1.1.0")
//        target("src/**/*.kt")
//    }
//    java {
//        removeUnusedImports()
//        googleJavaFormat("1.15.0")
//        target("**/*.java")
//    }
//}

android {
    namespace = "nl.dionsegijn.konfetti.compose"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {
    api(project(path = ":core"))
//    releaseApi("nl.dionsegijn:konfetti-core:2.1.0-beta01")

    implementation("com.github.mozhimen.ASwiftKit:composek:2.1.6")
}
