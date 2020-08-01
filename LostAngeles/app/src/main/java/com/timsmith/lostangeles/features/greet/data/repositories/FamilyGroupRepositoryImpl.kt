package com.timsmith.lostangeles.features.greet.data.repositories

import com.timsmith.lostangeles.features.greet.data.mappers.FamilyGroupMapper
import com.timsmith.lostangeles.features.greet.data.services.GroupsService
import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import com.timsmith.lostangeles.features.greet.domain.repositories.FamilyGroupRepository
import io.reactivex.Single
import javax.inject.Inject

class FamilyGroupRepositoryImpl @Inject constructor(
    private val familyGroupService: GroupsService
) : FamilyGroupRepository {
    private val familyGroupMapper = FamilyGroupMapper()
    override fun getFamilyGroups(): Single<List<FamilyGroupModel>> {

        return familyGroupService.getFamilyGroupList()
            .map {
                val familyList = ArrayList<FamilyGroupModel>()
                for (model in it) {
                    familyList.add(familyGroupMapper.toFamilyGroupModel(model))
                }
                familyList
            }
    }
}