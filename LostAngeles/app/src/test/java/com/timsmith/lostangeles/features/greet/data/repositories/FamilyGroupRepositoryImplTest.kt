package com.timsmith.lostangeles.features.greet.data.repositories

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.timsmith.lostangeles.features.greet.data.models.FamilyGroupDataModel
import com.timsmith.lostangeles.features.greet.data.services.GroupsService
import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class FamilyGroupRepositoryImplTest {
    lateinit var sut: FamilyGroupRepositoryImpl
    private val mockFamilyGroupService: GroupsService = mock()
    private val mockGroupList: Single<List<FamilyGroupDataModel>> = mock()

    @Before
    fun setUp() {
        sut = FamilyGroupRepositoryImpl(mockFamilyGroupService)
        whenever(mockFamilyGroupService.getFamilyGroupList()).thenReturn(mockGroupList)
    }

    @Test
    fun testGetNotesCallsServiceCorrectlyToGetNotes() {
        sut.getFamilyGroups()
        verify(mockFamilyGroupService.getFamilyGroupList())
    }
}