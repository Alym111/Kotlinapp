package com.example.appkotlin

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appkotlin.ui.theme.AppKotlinTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var count1 by remember { mutableStateOf(value = 0) }
    var count2 by remember { mutableStateOf(value = 0) }
    var count3 by remember { mutableStateOf(value = 0) }
    var Last_Clicked by remember { mutableStateOf(value = "") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(text = "Last clicked button: $Last_Clicked", color = Color.Red, modifier = Modifier.padding(all = 50.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp),modifier = Modifier.padding(all = 50.dp)){
            Text(
                text = "Count1: $count1",
                color = Color.Blue
            )
            Text(
                text = "Count2: $count2",
                color = Color.Green
            )
            Text(
                text = "Count3: $count3",
                color = Color.Black
            )

        }


        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)){
            Button(onClick = { count1 += 1; Last_Clicked = "Count1" }) { Text(text = "Count", color = Color.Blue) }
            Button(onClick = { count2 += 1;Last_Clicked = "Count2"  }) { Text(text = "Count", color = Color.Green) }
            Button(onClick = { count3 += 1;Last_Clicked = "Count3"  }) { Text(text = "Count", color = Color.Black) }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppKotlinTheme {
        Greeting("Android")
    }
}