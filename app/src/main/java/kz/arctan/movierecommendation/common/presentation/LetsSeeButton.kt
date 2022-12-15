package kz.arctan.movierecommendation.common.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LetsSeeButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(18.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF29B6F6),
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontSize = 22.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LestSeeButtonPreview() {
    LetsSeeButton(text = "Login") {

    }
}