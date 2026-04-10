import org.jetbrains.kotlin.cfg.pseudocode.and

//plugins {
////    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
//    id("org.jetbrains.dokka") version "1.7.0"
//}

buildscript {
    repositories {
//        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.6.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.25")//${Constants.kotlinVersion}")
//        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.7.0")
//        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
//        classpath("com.diffplug.spotless:spotless-plugin-gradle:6.23.3")
//        classpath("io.github.gradle-nexus:publish-plugin:1.3.0")
    }
}

//// Connect with the repository using properties from local.properties in the root of the project
//val properties = File(rootDir, "local.properties")
//if(properties.exists()) {
//    val localProperties = properties.inputStream().use { java.util.Properties().apply { load(it) } }
//    // Set up Sonatype repository
//    nexusPublishing {
//        repositories {
//            sonatype {
//                stagingProfileId.set(localProperties["sonatypeStagingProfileId"] as String?)
//                username.set(localProperties["ossrhUsername"] as String?)
//                password.set(localProperties["ossrhPassword"] as String?)
//            }
//        }
//    }
//}

subprojects {
    apply(plugin = "maven-publish")

    afterEvaluate {
        // Java Library 模块
        if (plugins.hasPlugin("java-library")) {
            extensions.configure<PublishingExtension>("publishing") {
                publications {
                    create<MavenPublication>("mavenJava") {
                        from(components["java"])
                        groupId = "com.github.mozhimen"
                        artifactId = project.name
                        version = "0.0.2"
                    }
                }
            }
        }
        // Android Library 模块
        else if (plugins.hasPlugin("com.android.library")) {
            val android = extensions.getByType<com.android.build.gradle.LibraryExtension>()
//            android.libraryVariants.all { variant ->

//            }
            android.libraryVariants.all {
                if (buildType.name == "release") {
                    val releaseAar = tasks.named ("bundle${name.capitalize()}Aar")

                    extensions.configure<PublishingExtension>("publishing") {
                        publications {
                            create<MavenPublication>("release") {
                                groupId = "com.github.mozhimen"
                                artifactId = project.name
                                version = "0.0.2"

                                // 使用任务输出的 AAR 文件
                                artifact(releaseAar) {
                                    builtBy(releaseAar)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}