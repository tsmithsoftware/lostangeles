package com.timsmith.lostangeles.features.greet.data.datasources

import com.timsmith.lostangeles.features.greet.app.models.FamilyGroup
import io.reactivex.Single

interface GroupRemoteDataSource {
    fun getGroups(): Single<List<FamilyGroup>>
}