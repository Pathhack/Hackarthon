package com.pnu.hackarthon.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.pnu.hackarthon._enums.TaskType
import com.pnu.hackarthon.domain.model.TaskLog
import com.pnu.hackarthon.domain.model.User
import com.pnu.hackarthon.domain.repository.TaskLogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val logRepository: TaskLogRepository
): ViewModel() {
    fun addTaskLog(type: TaskType) {
        val taskLog = TaskLog(
            id = Random().nextLong(),
            title = type.title,
            date = LocalDateTime.now()
        )
        User.gainXP(type.reward)

        CoroutineScope(Dispatchers.IO).launch {
            logRepository.insert(taskLog)
        }

    }
}