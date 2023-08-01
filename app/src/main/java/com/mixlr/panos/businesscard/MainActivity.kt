package com.mixlr.panos.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
                        name = stringResource(R.string.name),
                        phoneNumber = stringResource(R.string.phone_number),
                        socialText = stringResource(R.string.social_text),
                        email = stringResource(R.string.email_address)
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
    phoneNumber: String,
    socialText: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainHeader(
            jobTitle = jobTitle,
            name = name
        )
        Spacer(Modifier.height(200.dp))
        ContactDetails(
            phoneNumber = phoneNumber,
            socialText = socialText,
            email = email
        )
    }
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
fun ContactDetails(
    phoneNumber: String,
    socialText: String,
    email: String,
    modifier: Modifier = Modifier
) {
    val telephoneIcon: ImageVector = Icons.Rounded.Call
    val socialIcon: ImageVector = Icons.Rounded.Share
    val envelopeIcon: ImageVector = Icons.Rounded.Email
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactDetail(
            icon = telephoneIcon,
            text = phoneNumber
        )
        ContactDetail(icon = socialIcon, text = socialText)
        ContactDetail(icon = envelopeIcon, text = email)
    }
}

@Composable
fun ContactDetail(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        ContactIcon(
            icon = icon
        )
        ContactInfo(
            text = text
        )
    }
}

@Composable
fun ContactIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Column(
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = colorResource(id = R.color.android_green_dark)
        )
    }
}

@Composable
fun ContactInfo(
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.width(220.dp)
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = text
        )
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
            name = stringResource(R.string.name),
            phoneNumber = stringResource(R.string.phone_number),
            socialText = stringResource(R.string.social_text),
            email = stringResource(R.string.email_address)
        )
    }
}
