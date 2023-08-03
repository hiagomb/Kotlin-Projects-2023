package com.example.section24_jetpackcomposemvvmprojectexample.presentation.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConversionResult

@Composable
fun HistoryScreen(
    list: State<List<ConversionResult>>,
    modifier: Modifier = Modifier,
    onCloseTask: (ConversionResult) -> Unit,
    onClearAllTask: () -> Unit
) {

    Column() {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if(!list.value.isEmpty()){
                Text(text = "History", color = Color.Gray)
                OutlinedButton(onClick = {onClearAllTask()}) {
                    Text(text = "Clear All", color = Color.Gray)
                }
            }

        }   
        HistoryList(list = list, onCloseTask = { onCloseTask(it) })
    }


}