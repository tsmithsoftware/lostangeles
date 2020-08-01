package com.timsmith.lostangeles.features.greet.data.mappers

import com.timsmith.lostangeles.features.greet.data.models.FamilyGroupDataModel
import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel

/**
 * A mapper to map the FamilyGroupDataModel from the server to FamilyGroupModel in presentable form
 */
class FamilyGroupMapper {
    fun toFamilyGroupModel(familyGroupDataModel: FamilyGroupDataModel): FamilyGroupModel {
        return FamilyGroupModel(
            familyId = familyGroupDataModel.familyid,
            caravan = familyGroupDataModel.caravan,
            groupsize = familyGroupDataModel.groupsize
        )
    }

}