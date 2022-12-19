package kz.arctan.movierecommendation.main.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.arctan.movierecommendation.common.domain.TestData
import kz.arctan.movierecommendation.common.presentation.LetsSeeStaggeredLayout


@Composable
fun ChooseGenreView(
    viewModel: MainViewModel,
    navController: NavController,
) {
    val state by viewModel.mainState.collectAsState()
    ChooseGenreScreen(
        genres = state.genres,
        pickedGenres = state.selectedGenres,
        onPickGenre = { viewModel.reduce(MainEvent.GenrePickedMainEvent(it)) }
    )
}

@Composable
fun ChooseGenreScreen(
    genres: List<String>,
    pickedGenres: List<String>,
    onPickGenre: (String) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LetsSeeStaggeredLayout(
            modifier = Modifier.align(Alignment.Center)
        ) {
            genres.forEach { genre ->
                val backGroundColor = if (genre in pickedGenres) Color.Blue else Color.Cyan
                Button(
                    onClick = { onPickGenre(genre) },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(horizontal = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = backGroundColor,
                        contentColor = contentColorFor(backgroundColor = backGroundColor)
                    )
                ) {
                    Text(
                        text = genre,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChooseGenreScreenPreview() {
    val genres = listOf(
        "Action",
        "Adventure",
        "Animation",
        "Children",
        "Comedy",
        "Crime",
        "Documentary",
        "Drama",
        "Fantasy",
        "Film-Noir",
        "Horror",
        "IMAX",
        "Musical",
        "Mystery",
        "Romance",
        "Sci-Fi",
        "Thriller",
        "War",
        "Western",
        "(no genres listed)",
    )
    var selectedGenres by remember { mutableStateOf(emptyList<String>()) }
    ChooseGenreScreen(
        genres = genres,
        pickedGenres = selectedGenres,
        onPickGenre = {
            selectedGenres = if (it in selectedGenres) selectedGenres - it else selectedGenres + it
        }
    )
}