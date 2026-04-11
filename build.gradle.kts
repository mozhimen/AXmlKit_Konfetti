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
    val versionToPublished = "0.0.3"
    val groupIdToPublished = "com.github.mozhimen.AXmlKit_Konfetti"

    afterEvaluate {

        when {
            plugins.hasPlugin("java-library") -> {
                extensions.configure<PublishingExtension>("publishing") {
                    publications {
                        create<MavenPublication>("mavenJava") {
                            from(components["java"])
                            groupId = "com.github.mozhimen"
                            artifactId = project.name
                            version = versionToPublished

                            pom.withXml {
                                val dependenciesNode = asNode().appendNode("dependencies")

                                // 在执行时获取依赖，而不是配置时
                                val apiDeps = project.configurations["api"].allDependencies.toList()
                                val implDeps = project.configurations["implementation"].allDependencies.toList()

                                apiDeps.forEach { dep ->
                                    val depNode = dependenciesNode.appendNode("dependency")
                                    val groupId: String?
                                    val version: String?

                                    if (dep is ProjectDependency) {
                                        groupId = groupIdToPublished
                                        version = versionToPublished
                                    } else {
                                        groupId = dep.group
                                        version = dep.version
                                    }

                                    depNode.appendNode("groupId", groupId)
                                    depNode.appendNode("artifactId", dep.name)
                                    depNode.appendNode("version", version)
                                    depNode.appendNode("scope", "compile")

                                    println("[POM DEBUG] api dependency -> groupId: $groupId, artifactId: ${dep.name}, version: $version")
                                }

                                implDeps.forEach { dep ->
                                    val depNode = dependenciesNode.appendNode("dependency")
                                    val groupId: String?
                                    val version: String?

                                    if (dep is ProjectDependency) {
                                        groupId = groupIdToPublished
                                        version = versionToPublished
                                    } else {
                                        groupId = dep.group
                                        version = dep.version
                                    }

                                    depNode.appendNode("groupId", groupId)
                                    depNode.appendNode("artifactId", dep.name)
                                    depNode.appendNode("version", version)
                                    depNode.appendNode("scope", "runtime")

                                    println("[POM DEBUG] runtime dependency -> groupId: $groupId, artifactId: ${dep.name}, version: $version")
                                }
                            }
                        }
                    }
                }
            }

            project.plugins.hasPlugin("com.android.library") -> {
                val android = extensions.getByName("android") as com.android.build.gradle.LibraryExtension

                android.libraryVariants.all {
                    if (buildType.name == "release") {
                        val releaseAar = tasks.named("bundle${name.capitalize()}Aar")

                        extensions.configure<PublishingExtension>("publishing") {
                            publications {
                                create<MavenPublication>("release") {
                                    groupId = "com.github.mozhimen"
                                    artifactId = project.name
                                    version = versionToPublished

                                    artifact(releaseAar) {
                                        builtBy(releaseAar)
                                    }

                                    pom.withXml {
                                        val dependenciesNode = asNode().appendNode("dependencies")

                                        // 在执行时获取依赖
                                        val apiDeps = project.configurations["api"].allDependencies.toList()
                                        val implDeps = project.configurations["implementation"].allDependencies.toList()

                                        apiDeps.forEach { dep ->
                                            val depNode = dependenciesNode.appendNode("dependency")
                                            val groupId: String?
                                            val version: String?

                                            if (dep is ProjectDependency) {
                                                groupId = groupIdToPublished
                                                version = versionToPublished
                                            } else {
                                                groupId = dep.group
                                                version = dep.version
                                            }

                                            depNode.appendNode("groupId", groupId)
                                            depNode.appendNode("artifactId", dep.name)
                                            depNode.appendNode("version", version)
                                            depNode.appendNode("scope", "compile")

                                            println("[POM DEBUG] api dependency -> groupId: $groupId, artifactId: ${dep.name}, version: $version")
                                        }

                                        implDeps.forEach { dep ->
                                            val depNode = dependenciesNode.appendNode("dependency")
                                            val groupId: String?
                                            val version: String?

                                            if (dep is ProjectDependency) {
                                                groupId = groupIdToPublished
                                                version = versionToPublished
                                            } else {
                                                groupId = dep.group
                                                version = dep.version
                                            }

                                            depNode.appendNode("groupId", groupId)
                                            depNode.appendNode("artifactId", dep.name)
                                            depNode.appendNode("version", version)
                                            depNode.appendNode("scope", "runtime")

                                            println("[POM DEBUG] runtime dependency -> groupId: $groupId, artifactId: ${dep.name}, version: $version")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

//subprojects {
//    apply(plugin = "maven-publish")
//
//    afterEvaluate {
//        // Java Library 模块
//        if (plugins.hasPlugin("java-library")) {
//            extensions.configure<PublishingExtension>("publishing") {
//                publications {
//                    create<MavenPublication>("mavenJava") {
//                        from(components["java"])
//                        groupId = "com.github.mozhimen"
//                        artifactId = project.name
//                        version = "0.0.2"
//                    }
//                }
//            }
//        }
//        // Android Library 模块
//        else if (plugins.hasPlugin("com.android.library")) {
//            val android = extensions.getByType<com.android.build.gradle.LibraryExtension>()
////            android.libraryVariants.all { variant ->
//
////            }
//            android.libraryVariants.all {
//                if (buildType.name == "release") {
//                    val releaseAar = tasks.named ("bundle${name.capitalize()}Aar")
//
//                    extensions.configure<PublishingExtension>("publishing") {
//                        publications {
//                            create<MavenPublication>("release") {
//                                groupId = "com.github.mozhimen"
//                                artifactId = project.name
//                                version = "0.0.2"
//
//                                // 使用任务输出的 AAR 文件
//                                artifact(releaseAar) {
//                                    builtBy(releaseAar)
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}