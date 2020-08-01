package com.timsmith.lostangeles.features.greet.domain.models

data class FamilyGroupModel (
    var familyId: Int? = null,
    var groupsize: Int? = null,
    var caravan: Int? = null
) {
    override fun toString(): String {
        return "Family with id $familyId, with a group size of $groupsize heading to caravan $caravan"
    }
}