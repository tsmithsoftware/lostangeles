package com.timsmith.lostangeles.features.greet.app.models

/**
 * The Ledger records all trips taken that day for ease of reporting
 */
object Ledger {
    private val trips = arrayListOf<Trip>()
    fun record(trip: Trip) {
        trips.add(trip)
    }
    fun getTrips(): ArrayList<Trip> {
        return trips
    }

    fun clear() {
        trips.clear()
    }
}