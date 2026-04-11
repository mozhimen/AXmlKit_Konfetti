plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "nl.dionsegijn.samples.shared"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
//        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
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
    implementation(project(path = ":core"))
    implementation("com.github.mozhimen.ASwiftKit:basick:2.1.6")
}
