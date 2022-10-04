plugins {
    id("com.android.application")
    kotlin("kapt")
    kotlin("android")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.appId
        minSdk =ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Deps.kotlinJson)
    implementation(Deps.core)
    implementation(Deps.appcompat)
    implementation(Deps.composeCompiler)
    implementation(Deps.composeUI)
    implementation(Deps.composeMaterial)
    implementation(Deps.composePreview)
    implementation(Deps.composeActivity)
    implementation(Deps.composeViewModel)
    implementation(Deps.runtime)
    implementation(Deps.ktorClient)
    implementation(Deps.ktorSerializable)
    implementation(Deps.ktorLogging)
    implementation(Deps.ktorOkhttp)
    implementation(Deps.ktorCbor)
    implementation(Deps.ktorNegotiation)
    implementation(Deps.ktorSerializedGson)
    implementation(Deps.ktorGson)
    implementation(Deps.gson)
    implementation(Deps.coil)
    implementation(Deps.napier)
    debugCompileOnly(Deps.chuck)

    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.espresso)
    androidTestImplementation(Deps.uiTest)
    debugImplementation(Deps.uiTooling)
    debugImplementation(Deps.uiManifest)
}