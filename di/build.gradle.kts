plugins {
    id("flexcode.android.library")
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    id(libs.plugins.kotlin.serialization.get().pluginId)
    id(libs.plugins.google.secrets.get().pluginId)
    id("flexcode.spotless")
}

android {
    namespace = "com.flexcode.sduicompose.di"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(projects.domain)
    api(projects.data)

    implementation(libs.androidx.startup)

    api(libs.okhttp.logging)
    implementation(platform(libs.retrofit.bom))
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx.serialization)

    implementation(libs.kotlinx.serialization.json)

    implementation(platform(libs.firebase.bom))
    api(libs.firebase.database)

    api(libs.hilt.android)
    ksp(libs.hilt.compiler)
}

secrets {
    propertiesFileName = "local.properties"
    defaultPropertiesFileName = "local.properties"
}