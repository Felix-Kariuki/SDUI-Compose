plugins {
    id("flexcode.android.library")
    id("flexcode.android.library.compose")
    id("flexcode.android.hilt")
    id(libs.plugins.kotlin.serialization.get().pluginId)
    id("flexcode.spotless")
}

android {
    namespace = "com.flexcode.sduicompose.navigation"
}

dependencies {
    implementation(projects.designSystem)
    api(projects.domain)

    implementation(libs.kotlinx.coroutines.android)
    api(libs.androidx.navigation.compose)

    // Serialization
    implementation(libs.kotlinx.serialization.json)
}