package com.timsmith.lostangeles.shared.di.components

import android.content.Context
import com.timsmith.lostangeles.features.greet.app.ui.MainActivity
import com.timsmith.lostangeles.features.greet.app.ui.MainFragment
import com.timsmith.lostangeles.shared.di.scopes.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface CampsiteComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): CampsiteComponent
    }

    fun inject(context: Context)
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
}