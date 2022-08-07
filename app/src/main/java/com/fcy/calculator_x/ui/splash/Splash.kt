package com.fcy.calculator_x.ui.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fcy.calculator_x.R
import kotlinx.coroutines.delay

@Composable
fun Splash(
    navigateAction: () -> Unit
) {
    var start by remember {
        mutableStateOf(false)
    }
    val alpha by animateFloatAsState(
        targetValue = if (start) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    LaunchedEffect(key1 = Unit) {
        start = true
        println(Thread.currentThread())
        delay(1500)
        navigateAction()
    }

    Splash(alpha)
}

@Composable
fun Splash(
    alphaState: Float
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x4AAF0060)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .alpha(alpha = alphaState),
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = stringResource(id = R.string.app_name)
            )
            Text(style = TextStyle(fontSize = 25.sp), text = "欢迎")
        }
    }
}

@Preview
@Composable
private fun PreViewSplash() {
    Splash(alphaState = 1f)
}