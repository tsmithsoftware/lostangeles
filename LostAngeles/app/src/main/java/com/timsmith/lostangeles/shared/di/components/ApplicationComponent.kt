package com.timsmith.lostangeles.shared.di.components

import com.timsmith.lostangeles.shared.di.modules.GreetModule
import com.timsmith.lostangeles.shared.di.modules.NetworkModule
import com.timsmith.lostangeles.shared.di.modules.SubcomponentsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, SubcomponentsModule::class, GreetModule::class])
interface ApplicationComponent {
    fun campsiteComponent(): CampsiteComponent.Factory
}