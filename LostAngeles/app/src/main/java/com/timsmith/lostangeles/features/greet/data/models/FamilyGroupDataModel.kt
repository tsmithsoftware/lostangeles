package com.timsmith.lostangeles.features.greet.data.models

import com.google.gson.annotations.SerializedName

data class FamilyGroupDataModel (
    @SerializedName("familyid")
    val familyid: Int = -1,
    @SerializedName("groupsize")
    val groupsize: Int = -1,
    @SerializedName("caravan")
    val caravan: Int = -1
)