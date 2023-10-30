package com.example.videogamespace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.videogamespace.ui.theme.VideogameSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideogameSpaceTheme {
                VideogameSpace()
            }
        }
    }
}

@Composable
fun VideogameSpace() {
    var currentVideogame by remember { mutableStateOf(1) }
    if(currentVideogame == 0){
        currentVideogame = 6;
    }
    if(currentVideogame == 7){
        currentVideogame = 1;
    }
    val imagen = when (currentVideogame) {
        1 -> R.drawable.doom
        2 -> R.drawable.titanfall2
        3 -> R.drawable.vampiresurvivors
        4 -> R.drawable.lol
        5 -> R.drawable.baldursgate3
        6 -> R.drawable.backpackhero
        else -> R.drawable.doom
    }
    val texto = when (currentVideogame) {
        1 -> R.string.doomEternal
        2 -> R.string.titanFall2
        3 -> R.string.vampireSurvivors
        4 -> R.string.LOL
        5 -> R.string.baldursGate3
        6 -> R.string.backpackHero
        else -> ""
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .height(430.dp)
                    .width(300.dp)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = stringResource(texto as Int),
                fontSize = 40.sp)
            Spacer(modifier = Modifier.height(70.dp))
            Row {
                Button(onClick = { currentVideogame -= 1}) {
                    Text(text = stringResource(R.string.anterior),
                        fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.width(50.dp))
                Button(onClick = { currentVideogame += 1 }) {
                    Text(text = stringResource(R.string.siguiente),
                        fontSize = 20.sp)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VideogameSpaceTheme {
        VideogameSpace()
    }
}