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
    namespace = "nl.dionsegijn.xml.kotlin"
    compileSdk = 34

    defaultConfig {
        applicationId = "nl.dionsegijn.xml.kotlin"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "0.0.1"

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
}

dependencies {
    implementation(project(path = ":xml"))
    implementation(project(path = ":samples:shared"))
    implementation("com.github.mozhimen.ASwiftKit:basick:2.0.4")
    implementation("com.github.mozhimen.ASwiftKit:xmlk:2.0.4")
}
