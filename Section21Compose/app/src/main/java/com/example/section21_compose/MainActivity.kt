package com.example.section21_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.section21_compose.compose.TvShowListItem
import com.example.section21_compose.data.TvShowList
import com.example.section21_compose.model.TvShow
import com.example.section21_compose.ui.theme.Section21ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //scrollableColumnDemo()
//            lazyColumnDemo{
//                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
//            }
            DisplayTvShowList{

                startActivity(DetailsActivity.intent(this, it))
            }
        }
    }
}

@Composable
private fun DisplayTvShowList(selectedItem: (TvShow) -> Unit){
    val tvShows = remember{TvShowList.tvShows}
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem = selectedItem)
            }
        )
    }

}






// Equivalent to RecyclerView -> more efficient
//@Composable
//fun lazyColumnDemo(selectedItem : (String) -> Unit){
//    LazyColumn{
//        items(100){
//            Text(
//                text = "Username $it",
//                style = MaterialTheme.typography.h3,
//                modifier = Modifier
//                    .padding(12.dp)
//                    .clickable { selectedItem("$it selected") }
//            )
//            Divider(color = Color.Black, thickness = 5.dp)
//        }
//    }
//}

// Equivalent to ListView -> not efficient
//@Composable
//fun scrollableColumnDemo(){
//    val scrollState = rememberScrollState()
//    Column(
//        modifier = Modifier.verticalScroll(scrollState)
//    ){
//        for(i in 1..100){
//            Text(
//                text = "Username $i",
//                style = MaterialTheme.typography.h3,
//                modifier = Modifier.padding(12.dp)
//            )
//            Divider(color = Color.Black, thickness = 5.dp)
//        }
//    }
//}

//@Composable
//fun Greeting(name: String) {
//    Text(
//        text = "Hello $name!",
//        fontSize = 32.sp,
//        fontWeight = FontWeight.Bold,
//        color = Color.Red,
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .background(color = Color.Yellow)
//            .border(2.dp, color = Color.Green)
//            .padding(12.dp)
//
//    )
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Section21ComposeTheme {
//        Greeting("Android")
    }
}