package com.timsmith.lostangeles.features.greet.app

import com.timsmith.lostangeles.features.greet.app.models.*

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