package com.timsmith.lostangeles.features.greet.domain.usecases

import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import com.timsmith.lostangeles.features.greet.domain.repositories.FamilyGroupRepository
import io.reactivex.Single
import javax.inject.Inject

class GetDailyFamilyGroupsUseCase @Inject constructor(val familyGroupRepository: FamilyGroupRepository): SingleUseCase<List<FamilyGroupModel>> {
    override fun execute(): Single<List<FamilyGroupModel>> {
        return familyGroupRepository.getFamilyGroups()
    }
}