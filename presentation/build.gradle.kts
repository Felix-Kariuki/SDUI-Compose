plugins {
    id("flexcode.android.library")
    id("flexcode.android.library.compose")
    id("flexcode.android.feature")
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    id("flexcode.spotless")
}

android {
    namespace = "com.flexcode.sduicompose"

}

dependencies {
    api(projects.domain)

    api(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.coil.compose)
}