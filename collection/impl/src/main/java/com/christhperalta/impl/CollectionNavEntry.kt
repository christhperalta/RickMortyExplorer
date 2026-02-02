package com.christhperalta.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.christhperalta.api.Collection
import com.christhperalta.impl.ui.CollectionScreen


 fun EntryProviderScope<NavKey>.collectionEntry(backStack: NavBackStack<NavKey>) {
    entry<Collection> {
        CollectionScreen(
            onBack = { backStack.removeLastOrNull() }
        )
    }
}

