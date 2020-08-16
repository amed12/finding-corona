package com.sun3toline.fico.domain

import com.sun3toline.fico.domain.common.UseCase
import com.sun3toline.fico.domain.executor.JobExecutor
import com.sun3toline.fico.domain.executor.UIThread
import io.reactivex.Single

class HomeUseCase(
    private val repository: HomeRepository,
    executor: JobExecutor,
    thread: UIThread
) : UseCase<HomeEntity, HomeParam>(executor, thread) {
    override fun buildUseCaseObservable(params: HomeParam): Single<HomeEntity> =
        repository.discoverMovie(params)
}