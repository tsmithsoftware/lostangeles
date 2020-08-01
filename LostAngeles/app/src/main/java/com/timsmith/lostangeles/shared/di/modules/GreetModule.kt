package com.timsmith.lostangeles.shared.di.modules

import android.content.Context
import com.timsmith.lostangeles.features.greet.data.repositories.FamilyGroupRepositoryImpl
import com.timsmith.lostangeles.features.greet.data.services.GroupsService
import com.timsmith.lostangeles.features.greet.domain.repositories.FamilyGroupRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class GreetModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideGroupsService(retrofit: Retrofit): GroupsService {
        return retrofit.create(GroupsService::class.java)
    }

    @Provides
    fun provideGroupsRepository(groupsService: GroupsService): FamilyGroupRepository {
        return FamilyGroupRepositoryImpl(groupsService)
    }
}