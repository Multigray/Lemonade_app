package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           LemonadeTheme {
               LemonadeButtonApp()
           }
        }
    }
}


@Composable
fun LemonadeButton(modifier: Modifier = Modifier) {

    var result by remember { mutableIntStateOf(1) }
    val (image, description) = when (result) {
        1 -> Pair(R.drawable.lemon_tree, stringResource(R.string.lemon_tree))
        2, 3, 4 -> Pair(R.drawable.lemon_squeeze, stringResource(R.string.lemon))
        5 -> Pair(R.drawable.lemon_drink, stringResource(R.string.lemonade))
        else -> Pair(R.drawable.lemon_restart, stringResource(R.string.glass))
    }

    val consigne = when (result) {
        1 -> stringResource(R.string.lemon_tree_click)
        2, 3, 4 -> stringResource(R.string.lemon_click)
        5 -> stringResource(R.string.lemonade_click)
        else -> stringResource(R.string.glass_click)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {result = if (result < 6) result + 1 else 1},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF90D5FF)
            ),
            border = BorderStroke(5.dp, Color(0xFFFFF5E1)),
            shape = RoundedCornerShape(12.dp) ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = description
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = consigne,
            fontSize = 18.sp
        )

    }
}
@Composable
fun LemonadeButtonApp() {
   LemonadeButton()
}
