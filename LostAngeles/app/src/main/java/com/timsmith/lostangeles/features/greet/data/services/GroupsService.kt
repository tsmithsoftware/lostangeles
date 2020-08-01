package com.timsmith.lostangeles.features.greet.data.services

import com.timsmith.lostangeles.features.greet.data.models.FamilyGroupDataModel
import io.reactivex.Single
import retrofit2.http.GET

interface GroupsService {

    @GET("/groups")
    fun getFamilyGroupList(): Single<List<FamilyGroupDataModel>>
}