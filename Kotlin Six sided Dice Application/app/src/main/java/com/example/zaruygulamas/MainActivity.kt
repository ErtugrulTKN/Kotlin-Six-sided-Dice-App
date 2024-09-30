package com.example.zaruygulamas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.zaruygulamas.ui.theme.ZarUygulamasıTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZarUygulamasıTheme {
                ZarAtmaOyunu()

            }
        }
    }
}

@Preview
@Composable
fun ZarAtmaOyunu(){
    ButonlaZarAt(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}


@Composable
fun ButonlaZarAt(modifier: Modifier = Modifier){
    var sonuc by remember {
        mutableStateOf(1)
    }

    val zarResmi = when(sonuc){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier
    , horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = zarResmi)
            , contentDescription = sonuc.toString())
        Button(onClick = { sonuc = (1..6).random()  }) {
            Text(text = "Salla")
        }


    }
}