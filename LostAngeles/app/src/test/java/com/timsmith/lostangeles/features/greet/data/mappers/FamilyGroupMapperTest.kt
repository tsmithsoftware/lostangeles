package com.timsmith.lostangeles.features.greet.data.mappers

import com.timsmith.lostangeles.features.greet.data.models.FamilyGroupDataModel
import org.junit.Test

class FamilyGroupMapperTest {
    @Test
    fun test_Family_Group_Mapper_Correctly_Maps_Family_Group_Data_Model_To_Family_Group_Model() {
        val familyGroupDataModel = FamilyGroupDataModel(
            familyid = 1,
            caravan = 1,
            groupsize = 2
        )
        val result = FamilyGroupMapper().toFamilyGroupModel(familyGroupDataModel)
        assert(result.familyId == 1)
        assert(result.groupsize == 2)
        assert(result.caravan == 1)
    }
}