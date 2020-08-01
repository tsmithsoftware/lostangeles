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
        routeList.forEach {
            builder.append("$it, ")
        }
        val routeAsString = builder.deleteCharAt(builder.lastIndexOf(","))
        return routeAsString.toString()
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
