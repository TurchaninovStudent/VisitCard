package com.example.turchaninov.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.turchaninov.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    VisitCardInfo(
                        fullName = "Турчанинов Андрей Евгеньевич",
                        title = "создал это приложение",
                        phoneNumber = "+7 (921) 260-65-51",
                        socialMedia = "@CasCade",
                        email = "aeturchaninov@ya.ru"
                    )
                }
            }
        }
    }
}

@Composable
fun PersonInfo(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.personphoto)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier

    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = fullName,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(8.dp)
        )
        Text(
            text = title,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
    }
}

@Composable
fun SocialInfo(
    text: String,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .height(32.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = text,
            fontSize = 16.sp,
            lineHeight = 32.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
        )
    }
}

@Composable
fun SocialInfoGroup(
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    val phoneImage = painterResource(R.drawable.phoneicon)
    val telegramImage = painterResource(R.drawable.telegramicon)
    val emailImage = painterResource(R.drawable.emailicon)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        SocialInfo(
            text = phoneNumber,
            painter = phoneImage
        )
        SocialInfo(
            text = socialMedia,
            painter = telegramImage
        )
        SocialInfo(
            text = email,
            painter = emailImage
        )
    }
}

@Composable
fun VisitCardInfo(
    fullName: String,
    title: String,
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier)
        PersonInfo(
            fullName = stringResource(R.string.full_name_text),
            title = "создал это приложение"
        )
        SocialInfoGroup(
            phoneNumber = "+7 (921) 260-65-51",
            socialMedia = "@CasCade",
            email = "aeturchaninov@ya.ru"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VisitCardPreview() {
    VisitCardTheme {
        VisitCardInfo(
            fullName = "Турчанинов Андрей Евгеньевич",
            title = "создал это приложение",
            phoneNumber = "+7 (921) 260-65-51",
            socialMedia = "@CasCade",
            email = "aeturchaninov@ya.ru"
        )
    }
}