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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
                        fullName = stringResource(R.string.full_name_text),
                        title = stringResource(R.string.title_text),
                        phoneNumber = stringResource(R.string.phone_number_text),
                        socialMedia = stringResource(R.string.social_media_text),
                        email = stringResource(R.string.email_text)
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
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
        Text(
            text = fullName,
            fontSize = 28.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFd3F13c4),
            modifier = modifier
                .padding(8.dp)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Composable
fun SocialInfoIcon(
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .padding(8.dp)
    )
}

@Composable
fun SocialInfoIcons(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(54.dp)
            .padding(8.dp)
    ) {
        SocialInfoIcon(painter = painterResource(R.drawable.phoneicon), modifier)
        SocialInfoIcon(painter = painterResource(R.drawable.telegramicon), modifier)
        SocialInfoIcon(painter = painterResource(R.drawable.emailicon), modifier)
    }
}

@Composable
fun SocialInfoValue(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 16.sp,
        lineHeight = 32.sp,
        textAlign = TextAlign.Left,
        modifier = Modifier
            .padding(8.dp)
    )
}

@Composable
fun SocialInfoValues(
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(8.dp)
    ) {
        SocialInfoValue(phoneNumber, modifier)
        SocialInfoValue(socialMedia, modifier)
        SocialInfoValue(email, modifier)
    }
}

@Composable
fun SocialInfoGroup(
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Spacer(modifier)
        SocialInfoIcons(modifier)
        SocialInfoValues(
            phoneNumber = phoneNumber,
            socialMedia = socialMedia,
            email = email,
            modifier
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
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier)
        PersonInfo(
            fullName = fullName,
            title = title
        )
        SocialInfoGroup(
            phoneNumber = phoneNumber,
            socialMedia = socialMedia,
            email = email,
            modifier = modifier
                .padding(bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VisitCardPreview() {
    VisitCardTheme {
        VisitCardInfo(
            fullName = stringResource(R.string.full_name_text),
            title = stringResource(R.string.title_text),
            phoneNumber = stringResource(R.string.phone_number_text),
            socialMedia = stringResource(R.string.social_media_text),
            email = stringResource(R.string.email_text)
        )
    }
}