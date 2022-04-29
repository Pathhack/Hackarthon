package com.pnu.hackarthon.presentation.viewmodel

import com.pnu.hackarthon.domain.repository.TaskLogRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val logRepository: TaskLogRepository
) {

}