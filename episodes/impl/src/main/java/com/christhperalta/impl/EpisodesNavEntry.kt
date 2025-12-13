package com.christhperalta.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.christhperalta.api.Episodes
import com.christhperalta.impl.ui.EpisodesScreen

 fun EntryProviderScope<NavKey>.episodesEntry() {
    entry<Episodes> {
        EpisodesScreen()
    }
}