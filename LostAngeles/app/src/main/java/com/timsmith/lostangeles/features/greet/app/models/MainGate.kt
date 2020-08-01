package com.timsmith.lostangeles.features.greet.app.models

import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import java.util.*

interface IGate {
    fun getNextGroup(): FamilyGroupModel?
    fun hasGroups(): Boolean
}

class MainGate(private val groups: LinkedList<FamilyGroupModel>): IGate {
    override fun getNextGroup(): FamilyGroupModel? {
        return groups.pop()
    }

    override fun hasGroups(): Boolean {
        return groups.size > 0
    }
}