package com.pnu.hackarthon.presentation.view.TaskList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import com.pnu.hackarthon._enums.SortType
import com.pnu.hackarthon.presentation.component.DropDownButton

@Composable
fun SortingOption(
    onOptionChange: (SortType) -> Unit,
    currentOption: SortType
) {
    val items = listOf(SortType.NEWEST, SortType.OLDEST)

    Box(modifier = Modifier.fillMaxWidth()) {
        DropDownButton(
            modifier = Modifier.align(Alignment.CenterEnd),
            items = items,
            button = { expand ->
                Text(
                    modifier = Modifier.clickable { expand() },
                    text = currentOption.text,
                    textDecoration = TextDecoration.Underline
                )
            },
            item = { index, option ->
                Text(
                    text = option.text
                )
            },
            onItemClick = onOptionChange
        )
    }
}