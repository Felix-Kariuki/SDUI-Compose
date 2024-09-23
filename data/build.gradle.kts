plugins {
    id("flexcode.android.library")
    id("flexcode.spotless")
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.flexcode.sduicompose.data"
}

dependencies {
    api(projects.domain)

    implementation(libs.kotlinx.serialization.json)

    implementation(platform(libs.firebase.bom))
    api(libs.firebase.database.ktx)
    api(libs.firebase.database)

    api(libs.hilt.android)
    ksp(libs.hilt.compiler)
}