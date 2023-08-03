package com.example.section24_jetpackcomposemvvmprojectexample.presentation.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    modifier: Modifier = Modifier,
    onCloseTask: (ConversionResult) -> Unit
) {
    LazyColumn {
        items(items = list.value, key = { item -> item.id }) {
            HistoryItem(
                message1 = it.message1,
                message2 = it.message2,
                onClose = { onCloseTask(it) })
        }
    }
}