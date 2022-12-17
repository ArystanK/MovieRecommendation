package kz.arctan.movierecommendation.common.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LetsSeeTitle(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp,
            fontSize = 32.sp
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.caption,
            color = Color.Gray.copy(alpha = 0.5f),
            fontSize = 22.sp,
        )
    }
}