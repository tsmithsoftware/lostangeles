package com.timsmith.lostangeles.features.greet.domain.usecases

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import com.timsmith.lostangeles.features.greet.domain.repositories.FamilyGroupRepository
import com.timsmith.lostangeles.features.greet.domain.usecases.GetDailyFamilyGroupsUseCase
import io.reactivex.Single
import org.junit.Before
import org.junit.Test


class GetFamilyGroupUseCaseTest {

    private val mockFamilyGroupRepository: FamilyGroupRepository = mock()
    private val mockSingle: Single<List<FamilyGroupModel>> = mock()

    @Before
    fun setup() {
        whenever(mockFamilyGroupRepository.getFamilyGroups()).thenReturn(mockSingle)
    }

    @Test
    fun testUseCaseCallsRepoGetNotesMethod() {
        val sut = GetDailyFamilyGroupsUseCase(mockFamilyGroupRepository)
        val result = sut.execute()
        verify(mockFamilyGroupRepository).getFamilyGroups()
        assert(result == mockSingle)
    }
}