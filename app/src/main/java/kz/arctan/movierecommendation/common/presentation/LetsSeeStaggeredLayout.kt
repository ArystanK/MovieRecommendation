package kz.arctan.movierecommendation.common.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun LetsSeeStaggeredLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ) {
            var (x, y) = 0 to 0
            placeables.forEach {
                if (x + it.width > constraints.maxWidth) {
                    x = 0
                    y += it.height
                }
                it.place(x, y)
                x += it.width
            }
        }
    }
}
