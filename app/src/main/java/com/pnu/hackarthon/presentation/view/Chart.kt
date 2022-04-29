package com.pnu.hackarthon.presentation.view

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.pnu.hackarthon.R
import com.pnu.hackarthon.domain.model.TaskLog
import com.pnu.hackarthon.domain.repository.TaskLogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class Chart @Inject constructor(
    private val repository: TaskLogRepository
) : Activity() {
    private var allTasks: List<TaskLog> = emptyList<TaskLog>()
    init {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getAllTasks().collect {
                allTasks = it
            }
        }
    }
    val chart by lazy { findViewById<com.github.mikephil.charting.charts.PieChart>(R.id.pieChart) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_chart)

        chart.run {

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
                add(PieEntry(1.0F))
                add(PieEntry(1.0F))
                add(PieEntry(1.0F))
                add(PieEntry(1.0F))
                add(PieEntry(1.0F))
            }

            animateY(1000, Easing.EaseInOutCubic)

            val dataSet: PieDataSet = PieDataSet(yValues, "")
            with(dataSet) {
                sliceSpace = 3f
                selectionShift = 5f
                setColors(*ColorTemplate.JOYFUL_COLORS)
            }

            val pieData: PieData = PieData(dataSet)
            with(pieData) {
                setValueTextSize(10f)
                setValueTextColor(Color.BLACK)
                val des = Description()
                des.text = "도시별 확진자 상위 5곳"
                description = des
            }
            data = pieData
        }
    }
}