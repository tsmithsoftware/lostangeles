package com.timsmith.lostangeles.features.greet.app.models

import java.lang.StringBuilder
import java.util.*

class Route (var routeList: LinkedList<DestinationCampsiteNode>) {
    val time: Int
        get() {
        return routeList.size
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("Total route time: $time")
        builder.append(" Route: ")
        routeList.forEach {
            builder.append("$it, ")
        }
        val indexOfComma = builder.lastIndexOf(",")
        if (indexOfComma != -1) {
            builder.deleteCharAt(builder.lastIndexOf(","))
        }
        return builder.toString()
    }

    fun deepCopy(): Route {
        return Route(LinkedList(routeList))
    }

    override fun equals(other: Any?): Boolean {
        if (other is Route) {
            if (other.routeList.size == routeList.size) {
                val firstCheck = other.routeList.containsAll(routeList)
                val secondCheck = routeList.containsAll(other.routeList)
                return firstCheck && secondCheck
            }
        }
        return false
    }

    override fun hashCode(): Int {
        return Objects.hash(routeList, time)
    }
}
