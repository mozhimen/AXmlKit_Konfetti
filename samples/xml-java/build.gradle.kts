plugins {
    id("com.android.application")
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
    namespace = "nl.dionsegijn.xml.java"
    compileSdk = 34

    defaultConfig {
        applicationId = "nl.dionsegijn.xml.java"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    buildTypes {
        release {
            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    lint {
        abortOnError = true
        baseline = file("lint-baseline.xml")
    }
}

dependencies {
    implementation(project(path = ":xml"))
    implementation("com.github.mozhimen.ASwiftKit:basick:2.0.4")
    implementation("com.github.mozhimen.ASwiftKit:xmlk:2.0.4")
}
