package com.timsmith.lostangeles.features.greet.app.models

import java.util.*
import kotlin.text.StringBuilder

/**
 * A class representing a campsite destination
 * A campsite is represented as having a set of connected campsites as node edges
 * @param id the ID number of the campsite
 */
class DestinationCampsiteNode(val id: Int) {
    var connectedCampsites: ArrayList<Edge> = arrayListOf()
    var routeToNode: Route = Route(LinkedList())
    var visited: Boolean = false

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append(" Campsite $id")
        return builder.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (other is DestinationCampsiteNode) {
            if (other.id == id) {
                if (other.connectedCampsites.size == connectedCampsites.size) {
                    return true
                }
            }
        }
        return false
    }

    override fun hashCode(): Int {
        return Objects.hashCode(connectedCampsites)
    }

    fun addEdges(camps: List<DestinationCampsiteNode>) {
        val edges = arrayListOf<Edge>()
        for(camp in camps) {
            edges.add(Edge(start = this, end = camp))
        }
        connectedCampsites = edges
    }
}
