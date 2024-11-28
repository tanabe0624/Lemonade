package com.example.lemonede

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonede.ui.theme.LemonedeTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonedeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    lemonadeApp()
                }
            }
        }
    }
}

@Composable
fun lemonadeApp(){
    makeLemonade()
}

@Composable
fun makeLemonade(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Lemonade",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier
                //.background(Color.Green)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                //var result by remember by {}
                var result by remember { mutableStateOf(1) }
                var imageResource = when(result){
                    1 -> R.drawable.lemon_tree
                    2 -> R.drawable.lemon_squeeze
                    3 -> R.drawable.lemon_drink
                    else -> R.drawable.lemon_restart
                }

                var contentDescription = when(result){
                    1 -> R.string.lemon_tree_content_description
                    2 -> R.string.lemon_content_description
                    3 -> R.string.lemonade_content_description
                    else -> R.string.glass_content_description
                }

                var stringResource = when(result){
                    1 -> R.string.Select_lemon
                    2 -> R.string.Tap_lemon
                    3 -> R.string.Drink_lemonade
                    else -> R.string.Start_again
                }

                Button(onClick = { if(result < 4){
                    result++
                }else {
                    result = 1
                }
                }) {
                    Image(painter = painterResource(id = imageResource),
                        contentDescription = stringResource(id = contentDescription))
                }

                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(id = stringResource),
                    fontSize = 18.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonedeTheme {
        makeLemonade()
    }
}