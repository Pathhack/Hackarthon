package com.pnu.hackarthon.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.pnu.hackarthon.domain.repository.TaskLogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskLogViewModel @Inject constructor(
    private val repositry: TaskLogRepository
): ViewModel() {

    init {

    }
}