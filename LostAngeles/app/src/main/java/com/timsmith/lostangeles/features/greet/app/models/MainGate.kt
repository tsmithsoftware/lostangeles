package com.timsmith.lostangeles.features.greet.app.models

import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import java.util.*

interface IGate {
    fun getNextGroup(): FamilyGroupModel?
    fun hasGroups(): Boolean
}

/**
 * An Object representing a gate at which families arrive to be picked up
 */
class MainGate(private val groups: LinkedList<FamilyGroupModel>): IGate {
    override fun getNextGroup(): FamilyGroupModel? {
        return groups.pop()
    }

    override fun hasGroups(): Boolean {
        return groups.size > 0
    }
}