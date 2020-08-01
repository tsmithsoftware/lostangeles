package com.timsmith.lostangeles.features.greet.domain.usecases

import io.reactivex.Single

interface SingleUseCase<R> {
    fun execute(): Single<R>
}