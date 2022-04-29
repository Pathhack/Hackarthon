package com.pnu.hackarthon.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pnu.hackarthon.domain.model.TaskLog
import com.pnu.hackarthon.domain.repository.TaskLogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskLogViewModel @Inject constructor(
    private val repositry: TaskLogRepository
): ViewModel() {
    val taskLogs = mutableStateOf(emptyList<TaskLog>())

    init {
        CoroutineScope(Dispatchers.IO).launch {
            repositry.getAllTasks().collect() {
                taskLogs.value = it.sortedByDescending { it.date }
            }
        }
    }
}