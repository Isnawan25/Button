package com.example.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Background(pesan = "Ramadhan Penuh Berkah", pengirim ="Selamat Berbuka Puasa")
                    Gambarrandom()
                }
            }
        }
    }
}
@Composable
fun GreetingText(pesan: String, pengirim: String, modifier: Modifier = Modifier){
    val fontbagus = FontFamily(Font(R.font.fontramadhan))
    Column (verticalArrangement = Arrangement.Top)
    {
        Text(
            text = pesan,
            color = Color.White,
            fontSize = 45.sp,
            lineHeight = 45.sp,
            textAlign = TextAlign.Center,
            fontFamily = fontbagus
            )
    }
    Column (verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize())
    {
     Text(
         text = pengirim,
         color = Color.White,
         fontSize = 40.sp,
         lineHeight = 45.sp,
         textAlign = TextAlign.Center,
         modifier = Modifier.padding(0.dp),
         fontFamily = fontbagus
         )
    }
}

@Composable
fun Background(pesan: String, pengirim: String, modifier: Modifier = Modifier){
    val Gambar = painterResource(R.drawable.backgroundramadhan,)
    Box {
        Image(
            painter = Gambar,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.5F,
            contentScale = ContentScale.Crop
        )
        GreetingText(
            pesan = pesan,
            pengirim = pengirim,
            modifier = Modifier.fillMaxSize())
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPriview(){
    ButtonTheme { GreetingText(pesan = "Ramadhan Penuh Berkah", pengirim ="Selamat Berbuka Puasa")

    }
}
@Composable
fun GambarRandom(modifier: Modifier = Modifier){
    var hasil by remember {
        mutableStateOf(1)
    }

    val gambarAcak = when(hasil){
        1 -> R.drawable.mieayam
        2 -> R.drawable.satepincuk
        3 -> R.drawable.gorengan
        else -> R.drawable.ayamgoreng

    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(gambarAcak),
            contentDescription = "1")

        Button(onClick = { hasil = (1..4).random() }) {
            Text(text = stringResource(id = R.string.buttonAcak))
            
        }
    }

}
@Preview(showBackground = true)
@Composable
fun Gambarrandom(){
    GambarRandom()
}