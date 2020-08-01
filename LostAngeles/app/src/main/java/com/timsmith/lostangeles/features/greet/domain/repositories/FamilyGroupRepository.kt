package com.timsmith.lostangeles.features.greet.domain.repositories

import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import io.reactivex.Single

interface FamilyGroupRepository {
    fun getFamilyGroups(): Single<List<FamilyGroupModel>>
}