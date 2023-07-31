package com.example.checkboxcomposable

import androidx.compose.runtime.*
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkboxcomposable.ui.theme.CheckBoxComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyUI()
                }
            }
        }
    }
}

@Composable
fun MyUI(){
    // The checkbox: helps the use to select an item
    // Can turn an option ON or OFF
    var checked by remember{
        mutableStateOf(true)
    }

    val context = LocalContext.current

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked,
            onCheckedChange = {checkStatus ->
                checked = checkStatus

                Toast.makeText(context,
                    "You choose: $checkStatus",
                    Toast.LENGTH_LONG
                ).show()
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Blue
            )
        )
        Text(text = "Pizza")
    }



}