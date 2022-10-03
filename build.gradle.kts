plugins {
    id("org.jetbrains.kotlin.android") version Versions.kotlin apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }

    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}