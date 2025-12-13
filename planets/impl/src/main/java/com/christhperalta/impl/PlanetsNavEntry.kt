package com.christhperalta.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.christhperalta.api.Planets
import com.christhperalta.impl.ui.PlanetsScreen


fun EntryProviderScope<NavKey>.planetsEntry() {
    entry<Planets> {
        PlanetsScreen()
    }
}

