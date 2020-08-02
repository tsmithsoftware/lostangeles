package com.timsmith.lostangeles.features.greet.app.models

/**
 * A class representing a connection between campsites
 */
class Edge (
    var start: DestinationCampsiteNode? = null,
    var end: DestinationCampsiteNode? = null,
    var weight: Double = 1.0
) {
    override fun toString(): String {
        return "Edge: Start Node: ${start.toString()}, End Node: ${end.toString()}"
    }
}