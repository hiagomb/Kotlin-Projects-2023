package com.example.section24_jetpackcomposemvvmprojectexample.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.section24_jetpackcomposemvvmprojectexample.presentation.compose.BaseScreen
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterDatabase
import com.example.section24_jetpackcomposemvvmprojectexample.data.ConverterRepositoryImpl
import com.example.section24_jetpackcomposemvvmprojectexample.presentation.theme.Section24JetpackComposeMVVMProjectExampleTheme
import com.example.section24_jetpackcomposemvvmprojectexample.presentation.viewModel.ConverterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var factory: ConverterViewModel.ConverterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Section24JetpackComposeMVVMProjectExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BaseScreen(factory)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Section24JetpackComposeMVVMProjectExampleTheme {
        Greeting("Android")
    }
}