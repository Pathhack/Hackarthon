package com.pnu.hackarthon.presentation.view

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.ui.input.key.Key.Companion.D
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.pnu.hackarthon.R
import com.pnu.hackarthon.domain.model.TaskLog
import com.pnu.hackarthon.domain.repository.TaskLogRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class Chart : ComponentActivity() {
    private var allTasks: List<TaskLog> = emptyList<TaskLog>()
    val chart by lazy { findViewById<com.github.mikephil.charting.charts.PieChart>(R.id.pieChart) }
    @Inject
    lateinit var repository : TaskLogRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_chart)

        runBlocking {
            allTasks = repository.getAllTasks().first()
        }

        with(chart) {
            setUsePercentValues(true)
            description.isEnabled = false
            setExtraOffsets(5f, 10f, 5f, 5f)
            isDrawHoleEnabled = true
            setHoleColor(Color.WHITE)
            transparentCircleRadius = 61f

            val yValues: ArrayList<PieEntry> = ArrayList()
            with(yValues) {
                add(PieEntry(allTasks.count { it -> it.title == "분유" }.toFloat(), "분유"))
                add(PieEntry(allTasks.count { it -> it.title == "기저귀" }.toFloat(), "기저귀"))
                add(PieEntry(allTasks.count { it -> it.title == "수면" }.toFloat(), "수면"))
                add(PieEntry(allTasks.count { it -> it.title == "이유식" }.toFloat(), "이유식"))
            }

            animateY(1000, Easing.EaseInOutCubic)

            val dataSet: PieDataSet = PieDataSet(yValues, "")
            with(dataSet) {
                sliceSpace = 4f
                selectionShift = 15f
                setColors(*ColorTemplate.JOYFUL_COLORS)

            }

            val pieData: PieData = PieData(dataSet)
            with(pieData) {
                setValueTextSize(12f)
                setValueTextColor(Color.BLACK)
                val des = Description()
                des.text = "육아 액티비티 발생 비율"
                description = des
            }
            data = pieData
        }
    }
}