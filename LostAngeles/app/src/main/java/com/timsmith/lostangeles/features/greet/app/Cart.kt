package com.timsmith.lostangeles.features.greet.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.timsmith.lostangeles.features.greet.app.models.*
import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import java.util.*

/**
 * An object representing the cart in which the FamilyGroups are taken to the Campsite.
 * The Ledger holds all recorded Trips
 */
class Cart (var name: String) {
    var timeLeftOnRoute: Int = 0

    fun decrementTimeByOne() {
        if (timeLeftOnRoute != 0) {
            timeLeftOnRoute -= 1
        }
    }

    fun takeGroup(group: FamilyGroupModel): Boolean {
        if (timeLeftOnRoute == 0) {
            group.caravan?.let {
                val route = SiteMap.getShortestRouteFor(it)
                val trip = Trip(route = route, group = group)
                timeLeftOnRoute = route?.time ?: 0
                Ledger.record(trip)
                return true
            }
        }
        return false
    }

    /**fun startAndWriteToLedger(gate: MainGate) {
        this.hasStarted = true
        gate.getNextGroup()?.let { group ->
                group.caravan?.let {
                    val route = SiteMap.getShortestRouteFor(it)
                    val trip = Trip(route = route, group = group)
                    Ledger.record(trip)
                    this.hasStarted = false
                }
            }

        this.hasStarted = false
    }**/
}