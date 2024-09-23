plugins {
    id("flexcode.android.library")
    id("flexcode.android.library.compose")
    id("flexcode.spotless")
}

android {
    namespace = "com.flexcode.sduicompose.designsystem"
}

dependencies {
    api(projects.domain)

    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.constraintlayout)
    implementation(libs.coil.compose)
}