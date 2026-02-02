package com.christhperalta.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.christhperalta.api.Missions
import com.christhperalta.impl.ui.MissionsScreens


fun EntryProviderScope<NavKey>.missionsEntry(backStack: NavBackStack<NavKey>) {
    entry<Missions>() {
        MissionsScreens(
            onBack = { backStack.removeLastOrNull() }
        )
    }
}
