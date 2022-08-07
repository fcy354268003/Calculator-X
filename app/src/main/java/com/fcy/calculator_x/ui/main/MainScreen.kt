package com.fcy.calculator_x.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fcy.calculator_x.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .weight(1F),
                maxLines = 2,
                text = viewModel.currentText.value,
                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                textAlign = TextAlign.End,
            )
            Spacer(modifier = Modifier.weight(1F))
            InputKeyBoard(viewModel)
        }
    }
}

@Composable
fun ColumnScope.InputKeyBoard(
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .weight(3F),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (i in ((1..20) step 4)) {
            RowNumber(i, viewModel)
        }
    }
}

@Composable
private fun ColumnScope.RowNumber(i: Int = 1, viewModel: MainViewModel) {
    Row(
        modifier = Modifier
            .weight(1F)
            .wrapContentWidth()
    ) {
        NumberEle(i = i, viewModel.elements[i - 1], viewModel::onElementClick)
        NumberEle(i = i + 1, viewModel.elements[i], viewModel::onElementClick)
        NumberEle(i = i + 2, viewModel.elements[i + 1], viewModel::onElementClick)
        NumberEle(i = i + 3, viewModel.elements[i + 2], viewModel::onElementClick)
    }
}

@Composable
@Preview
fun RowScope.NumberEle(
    i: Int = 0,
    content: String = "hhh",
    action: (Int) -> Unit = {},
) {
    if (content.isBlank())
        return
    val modifier =
        if (i == 1) Modifier
            .weight(2F) else Modifier
            .weight(1F)
    Button(
        modifier = modifier
            .fillMaxHeight()
            .border(1.dp, Color.Gray)
            .clickable {}
            .background(Color.White),
        onClick = { action(i) },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(0)
    ) {
        Text(
            modifier = Modifier
                .background(Color.White),
            text = content,
            style = TextStyle(color = Color.Black, fontSize = 30.sp),
            textAlign = TextAlign.Center,
        )
    }

}