package com.flexcode.sduicompose.designsystem.uiVersion

import com.flexcode.sduicompose.domain.models.ScreenUi


enum class UiVersion(val value: Int) {
    VERSION_1_0(1),
    VERSION_2_0(2);

    companion object {

        fun toUiVersion(value: Int?): UiVersion {
            return when (value) {
                VERSION_1_0.value -> VERSION_1_0
                VERSION_2_0.value -> VERSION_2_0
                else -> VERSION_1_0
            }
        }
    }
}

val ScreenUi.uiVersion: UiVersion
    get() = UiVersion.toUiVersion(version)
