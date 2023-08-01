package com.mixlr.panos.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mixlr.panos.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        jobTitle = stringResource(R.string.job_title),
                        name = stringResource(R.string.name)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    jobTitle: String,
    name: String,
    modifier: Modifier = Modifier
) {
    MainHeader(
        jobTitle = jobTitle,
        name = name
    )
}

@Composable
fun MainHeader(
    jobTitle: String,
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        Name(name = name)
        JobTitle(jobTitle = jobTitle)
    }
}

@Composable
fun Name(name: String, modifier: Modifier = Modifier) {
    Text(
        fontSize = 50.sp,
        text = name
    )
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Image(
        contentDescription = null,
        painter = image,
        modifier = Modifier
            .background(Color.Black)
            .border(1.dp, Color.Black)
            .height(150.dp)
    )
}

@Composable
fun JobTitle(
    jobTitle: String,
    modifier: Modifier = Modifier
) {
    Text(
        color = colorResource(id = R.color.android_green_dark),
        fontWeight = FontWeight.Bold,
        text = jobTitle
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            jobTitle = stringResource(R.string.job_title),
            name = stringResource(R.string.name)
        )
    }
}
