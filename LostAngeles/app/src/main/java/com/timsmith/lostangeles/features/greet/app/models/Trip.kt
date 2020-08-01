package com.timsmith.lostangeles.features.greet.app.models

import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel

class Trip(val route: Route?, val group: FamilyGroupModel) {
    override fun toString(): String {
        return "Trip details for trip with group id ${group.familyId} going to ${group.caravan} - ${route.toString()}"
    }
}