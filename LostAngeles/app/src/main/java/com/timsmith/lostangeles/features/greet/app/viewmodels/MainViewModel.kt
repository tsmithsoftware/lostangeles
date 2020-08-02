package com.timsmith.lostangeles.features.greet.app.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timsmith.lostangeles.features.greet.domain.models.FamilyGroupModel
import com.timsmith.lostangeles.features.greet.domain.usecases.GetDailyFamilyGroupsUseCase
import io.reactivex.Observer
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getDailyFamilyGroupsUseCase: GetDailyFamilyGroupsUseCase
) : ViewModel() {
    private val familyList: MutableLiveData<List<FamilyGroupModel>> by lazy {
        MutableLiveData<List<FamilyGroupModel>>().also {
            loadFamilyGroupsForToday()
        }
    }

    fun getFamilyList(): LiveData<List<FamilyGroupModel>> {
        return familyList
    }

    private fun loadFamilyGroupsForToday() {
        getDailyFamilyGroupsUseCase.execute()
            .subscribeOn(Schedulers.io())
            .subscribeWith(object: DisposableSingleObserver<List<FamilyGroupModel>>(), Observer<FamilyGroupModel> {
                override fun onSuccess(obtainedFamilyList: List<FamilyGroupModel>?) {
                    familyList.postValue(obtainedFamilyList)
                }

                override fun onError(e: Throwable?) {
                    e?.let {
                        Log.d(this.javaClass.canonicalName, "Error in obtaining family groups: ${e.message}")
                    }
                }

                override fun onComplete() {}

                override fun onNext(value: FamilyGroupModel?) {}

            })
    }
}