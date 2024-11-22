package com.hjw.domain.usecase

import com.hjw.domain.repository.WidgetRepository
import javax.inject.Inject

class FetchWidgetListUseCase @Inject constructor(
    private val repository: WidgetRepository,
) {
    suspend operator fun invoke() = repository.fetchWidgetList()
}
