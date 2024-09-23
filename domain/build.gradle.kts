plugins {
    id("flexcode.android.library")
    id("kotlin-parcelize")
    id(libs.plugins.kotlin.serialization.get().pluginId)
    id("flexcode.spotless")
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.flexcode.sduicompose.domain"
}

dependencies {
    implementation(libs.kotlinx.reflect)
    api(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.android)

    api(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
}