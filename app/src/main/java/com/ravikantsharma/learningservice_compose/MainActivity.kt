package com.ravikantsharma.learningservice_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ravikantsharma.learningservice_compose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningServiceComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Cream
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Cream
    ) {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        TopBar()
        Text(
            text = "Hi Ravi, Let's start learning.",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        ScoreCard()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.round_menu_24),
            contentDescription = "Drawer"
        )
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Profile",
        )
    }
}

@Composable
fun ScoreCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            backgroundColor = MediumPurple,
            modifier = Modifier
                .fillMaxWidth()
                .height(Dp.Unspecified)
                .clip(RoundedCornerShape(24.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Continue your lesson with excited",
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row {
                    LessonProgress(
                        progress = 76f,
                        progressColor = MediumOrange,
                        postfix = "%"
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    LessonProgress(
                        progress = 30f,
                        progressColor = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Continue",
                        style = MaterialTheme.typography.h6,
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.round_arrow_forward_24),
                        contentDescription = "Continue",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .alpha(0.4f),
                    )
                }
            }
        }
        Card(
            backgroundColor = LightOrange2,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(24.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp,
                        topEnd = 0.dp,
                        topStart = 0.dp
                    )
                )
        ) {}
    }
}

@Composable
fun LessonProgress(
    progress: Float,
    progressColor: Color,
    postfix: String = ""
) {
    val rProgress by remember {
        mutableStateOf(progress.toInt())
    }

    val cP = rProgress / 100f

    Box(
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = cP,
            color = progressColor,
            backgroundColor = Color.LightGray.copy(alpha = .2f),
            strokeCap = StrokeCap.Round,
            modifier = Modifier.size(60.dp)
        )
        Text(
            text = "$rProgress$postfix",
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
    }
}