package com.timsmith.lostangeles.features.greet.app

import com.timsmith.lostangeles.features.greet.app.models.*

/**
 * An object representing the cart in which the FamilyGroups are taken to the Campsite.
 * The Ledger holds all recorded Trips
 */
object Cart {
    fun startAndWriteToLedger(gate: MainGate) {
        Ledger.clear()
        while(gate.hasGroups()) {
            gate.getNextGroup()?.let { group ->
                group.caravan?.let {
                    val route = SiteMap.getShortestRouteFor(it)
                    val trip = Trip(route = route, group = group)
                    Ledger.record(trip)
                }
            }
        }
    }
}