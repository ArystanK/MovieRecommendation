package kz.arctan.movierecommendation.common.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import kotlin.math.ceil

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
        val height: Int =
            ceil(placeables.sumOf { it.width }.toDouble() /
                    constraints.maxWidth).toInt() *
                    (placeables.firstOrNull()?.height ?: 0)
        layout(
            width = constraints.maxWidth,
            height = height
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
