plugins {
    id("com.android.application")
    id("kotlin-android")
//    id("com.diffplug.spotless")
}

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
    namespace = "nl.dionsegijn.xml.compose"
    compileSdk = 35

    defaultConfig {
        applicationId = "nl.dionsegijn.xml.compose"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    implementation(project(path = ":compose"))
    implementation(project(path = ":samples:shared"))

    implementation("com.github.mozhimen.ASwiftKit:basick:2.1.6")
    implementation("com.github.mozhimen.ASwiftKit:composek:2.1.6")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.15")
}
