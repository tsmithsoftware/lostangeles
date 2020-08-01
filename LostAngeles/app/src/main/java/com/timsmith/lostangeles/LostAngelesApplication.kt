package com.timsmith.lostangeles

import android.app.Application
import com.timsmith.lostangeles.shared.di.components.ApplicationComponent
import com.timsmith.lostangeles.shared.di.components.DaggerApplicationComponent
import com.timsmith.lostangeles.shared.di.modules.GreetModule

class LostAngelesApplication: Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent: ApplicationComponent = DaggerApplicationComponent
        .builder()
        .greetModule(GreetModule(this))
        .build()
}
