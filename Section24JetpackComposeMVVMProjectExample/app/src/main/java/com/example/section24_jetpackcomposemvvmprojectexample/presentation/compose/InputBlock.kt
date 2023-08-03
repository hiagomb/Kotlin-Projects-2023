package com.example.section24_jetpackcomposemvvmprojectexample.presentation.theme

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.section24_jetpackcomposemvvmprojectexample.data.Conversion

@Composable
fun InputBlock(
    conversion: Conversion, inputText: MutableState<String>, isLandscape: Boolean,
    modifier: Modifier = Modifier, context: Context = LocalContext.current,
    calculate: (String) -> Unit
) {

    if(isLandscape){
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Row() {
                TextField(
                    value = inputText.value,
                    onValueChange = { inputText.value = it },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f)
                    ),
                    textStyle = TextStyle(color = Color.DarkGray, fontWeight = FontWeight(30))
                )
                Text(
                    text = conversion.convertFrom,
                    fontSize = 24.sp,
                    modifier = modifier
                        .padding(10.dp, 30.dp, 0.dp, 0.dp)
                )
            }

            Spacer(modifier = modifier.height(20.dp))

            OutlinedButton(
                onClick = {
                    if (!inputText.value.isEmpty()) {
                        calculate(inputText.value)
                    } else {
                        Toast.makeText(context, "Type a number", Toast.LENGTH_SHORT).show()
                    }
                },
            ) {//textPart of the button
                Text(
                    text = "Convert",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
        }
    }else{
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = inputText.value,
                    onValueChange = { inputText.value = it },
                    modifier = Modifier.fillMaxWidth(0.65f),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f)
                    ),
                    textStyle = TextStyle(color = Color.DarkGray, fontWeight = FontWeight(30))
                )
                Text(
                    text = conversion.convertFrom,
                    fontSize = 24.sp,
                    modifier = modifier
                        .padding(10.dp, 30.dp, 0.dp, 0.dp)
                        .fillMaxWidth(0.35f)
                )
            }

            Spacer(modifier = modifier.height(20.dp))

            OutlinedButton(
                onClick = {
                    if (!inputText.value.isEmpty()) {
                        calculate(inputText.value)
                    } else {
                        Toast.makeText(context, "Type a number", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = modifier.fillMaxWidth(1f)
            ) {//textPart of the button
                Text(
                    text = "Convert",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
        }
    }


}