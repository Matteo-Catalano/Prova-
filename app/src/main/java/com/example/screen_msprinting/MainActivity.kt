package com.example.screen_msprinting

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieComposition
import com.example.screen_msprinting.ui.theme.Screen_msPrintingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen_msPrintingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Body()
                }
            }
        }
    }
}


@Composable
fun Body() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Prima riga con 2 immagini
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.refill_can),
                contentDescription = "Image 1",
                modifier = Modifier
                    .weight(1f)
                    .height(350.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.low_level),
                contentDescription = "Image 2",
                modifier = Modifier
                    .weight(1f)
                    .height(250.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Seconda riga con 2 bottoni
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            PersonalizedButton(true, "PRESS TO REFILL")
            PersonalizedButton(false, "CONTINUE TO PRINT")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Terza riga con 4 bottoni
        GridButtonsRow(
            buttons = listOf(
                ButtonInfo("NFC in refill bag detected"),
                ButtonInfo("NFC in refill bag not detected"),
                ButtonInfo("Partial refill"),
                ButtonInfo("Refill whit an expired ink / tank alredy used")
            )
        )
    }
}


@Composable
fun ChooseScenarioScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
            .background(Color(0xFF6BDBFF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 15.dp)
                .fillMaxWidth()
                .background(
                    color = Color(0xFF35A2C6),
                    shape = RoundedCornerShape(40.dp)
                ),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "Choose your scenario",
                style = myTextStyleSemiBold,
            )

        }
        GridButtonsRow(
            buttons = listOf(
                ButtonInfo("NFC in refill bag detected"),
                ButtonInfo("NFC in refill bag not detected"),
            )
        )
        GridButtonsRow(
            buttons = listOf(
                ButtonInfo("Partial refill"),
                ButtonInfo("Refill whit an expired ink / tank alredy used"),
            )
        )
        Text(
            text = "This step will not be showed because the algorithm will identify automatically the path to follow.",
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 100.dp, vertical = 10.dp)
        )
    }
}


@Composable
fun GridButtonsRow(buttons: List<ButtonInfo>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 72.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        for (button in buttons) {
            Button(
                shape = RoundedCornerShape(40.dp),
                elevation = ButtonDefaults.elevation(10.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1F)
            ) {
                Text(
                    text = button.text,
                    style = myTextStyle,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

data class ButtonInfo(
    val text: String,
)

@Composable
fun PersonalizedButton(isEnabled: Boolean, text: String) {
    val backgroundColor = if (isEnabled) Color(0xFF6BDBFF) else Color.Gray
    Button(modifier = Modifier
        .padding(20.dp)
        .width(400.dp)
        .height(150.dp),
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        elevation = ButtonDefaults.elevation(10.dp),
        onClick = {}) {
        Text(
            textAlign = TextAlign.Center,
            text = text,
            style = myTextStyleRegular)
    }
}


