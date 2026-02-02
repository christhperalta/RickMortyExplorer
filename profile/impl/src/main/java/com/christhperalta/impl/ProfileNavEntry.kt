package com.christhperalta.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.christhperalta.api.Profile
import com.christhperalta.impl.ui.ProfileScreen

 fun EntryProviderScope<NavKey>.profileEntry() {
    entry<Profile> {
        ProfileScreen()
    }
}
