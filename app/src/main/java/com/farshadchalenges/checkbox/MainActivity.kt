package com.farshadchalenges.checkbox

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farshadchalenges.checkbox.ui.theme.CheckBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckBoxExample()
                }
            }
        }
    }
}

@Composable
fun CheckBoxExample() {
    val myText = remember {
        mutableStateOf("What is your Gender ? ")
    }
    val myColor = 0xFFF3E9B4

    val firstCheckBox = remember {
        mutableStateOf(false)
    }
    val secondCheckBox = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(myColor)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(150.dp))
        Text(
            text = myText.value,
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier
                .background(Color(0xFF50C9FF))
                .padding(10.dp)
                .shadow(1.dp)
        )
        Spacer(modifier = Modifier.padding(50.dp))

        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = firstCheckBox.value,
                    onCheckedChange ={
                        firstCheckBox.value = it
                        if (firstCheckBox.value){
                            myText.value = "Your gender is Male!"
                        }else{
                            myText.value = "What is your gender ?"
                        }

                    },
                    colors = CheckboxDefaults.colors(Color.Cyan)
                )
                Text(
                    text = "Male",
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = secondCheckBox.value,
                    onCheckedChange ={
                        secondCheckBox.value = it
                        if (secondCheckBox.value){
                            myText.value = "Your gender is Female!"
                        }else{
                            myText.value = "What is your gender ?"
                        }
                    },
                    colors = CheckboxDefaults.colors(Color.Cyan)
                )
                Text(
                    text = "Female",
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    CheckBoxTheme {
        CheckBoxExample()
    }
}