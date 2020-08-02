package com.timsmith.lostangeles.features.greet.app.models

import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import java.io.Serializable

/**
 * Represents the route that a Group takes to a CampsiteDestination
 */
class Trip(val route: Route?, val group: FamilyGroupModel): Serializable {
    override fun toString(): String {
        return "Trip details for trip with group id ${group.familyId} going to ${group.caravan} - ${route.toString()}"
    }

    fun shortString(): String {
        return "Trip - group ${group.familyId} to caravan ${group.caravan}"
    }
}