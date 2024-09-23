package com.flexcode.sduicompose.domain.models

import kotlin.reflect.full.memberProperties

fun UiComponent.buildUiComponentList(
    uiComponents: List<UiComponent> = emptyList()
): List<UiComponent> {
    val mutableUiLists = mutableListOf<UiComponent>()
    mutableUiLists.addAll(uiComponents)


    this.javaClass.kotlin.memberProperties.sortedBy { member ->
        val uiComponent = member.get(this) as? OrderedUiComponent
        uiComponent?.order
    }.forEach { parent ->
        val uiComponent = parent.get(this) as? UiComponent ?: return@forEach
        var isNested = false
        uiComponent.javaClass.kotlin.memberProperties.reversed().forEach { child ->
            val childComponent = child.get(uiComponent) as? UiComponent
            if (childComponent != null) {
                mutableUiLists.add(childComponent)
                childComponent.buildUiComponentList(mutableUiLists)
                isNested = true
            }
        }

        if (!isNested) {
            mutableUiLists.add(uiComponent)
        }
    }
    return mutableUiLists
}