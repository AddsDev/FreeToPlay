object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.android}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

object Deps {
    /**
     * Compose
     */
    val core by lazy { "androidx.core:core-ktx:${Versions.kotlin}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val composeCompiler by lazy { "androidx.compose.compiler:compiler:${Versions.composeCompiler}" }
    val composeUI by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}" }
    val composeMaterial by lazy { "androidx.compose.material3:material3:${Versions.material}" }
    val runtime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtimeKtx}" }

    /**
     * Utilities
     */
    val ktorClient by lazy { "io.ktor:ktor-client-android:${Versions.ktor}" }
    val ktorSerializable by lazy { "io.ktor:ktor-client-serialization:${Versions.ktor}" }
    val ktorLogging by lazy { "io.ktor:ktor-client-logging-jvm:${Versions.ktor}" }
    val ktorOkhttp by lazy { "io.ktor:ktor-client-okhttp:${Versions.ktor}" }
    val chuck by lazy { "com.readystatesoftware.chuck:library:${Versions.chuck}" }
    val ktorGson by lazy { "io.ktor:ktor-client-gson:${Versions.ktor}" }
    val ktorCbor by lazy { "io.ktor:ktor-serialization-kotlinx-cbor:${Versions.ktor}" }
    val ktorNegotiation by lazy { "io.ktor:ktor-client-content-negotiation:${Versions.ktor}" }
    val ktorSerializedGson by lazy { "io.ktor:ktor-serialization-gson:${Versions.ktor}" }


    val kotlinJson by lazy { "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinJson}" }

    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }

    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }

    val napier by lazy { "io.github.aakira:napier:${Versions.napier}" }


    /**
     * Testing
     */
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val junitExt by lazy { "androidx.test.ext:junit:${Versions.junitExt}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val uiTest by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val uiManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }
}