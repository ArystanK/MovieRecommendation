package kz.arctan.movierecommendation.main.presentation

import androidx.compose.foundation.layout.*
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
import kz.arctan.movierecommendation.Routes
import kz.arctan.movierecommendation.common.presentation.LetsSeeButton
import kz.arctan.movierecommendation.common.presentation.LetsSeeStaggeredLayout


@Composable
fun ChooseGenreView(
    viewModel: ChooseGenreViewModel,
    navController: NavController,
) {
    val state by viewModel.mainState.collectAsState()
    ChooseGenreScreen(
        genres = state.genres,
        pickedGenres = state.selectedGenres,
        onPickGenre = { viewModel.reduce(GenreChooseEvent.GenrePickedGenreChooseEvent(it)) },
        onSubmit = {
            navController.navigate(Routes.MovieListView)
        }
    )
}

@Composable
fun ChooseGenreScreen(
    genres: List<String>,
    pickedGenres: List<String>,
    onPickGenre: (String) -> Unit,
    onSubmit: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LetsSeeStaggeredLayout(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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
        LetsSeeButton(onClick = onSubmit, text = "Submit")
    }
}

@Preview(showBackground = true)
@Composable
fun ChooseGenreScreenPreview() {
    val genres = listOf(
        "Documentary",
        "Science Fiction",
        "Western",
        "Comedy",
        "Foreign",
        "Drama",
        "Fantasy",
        "History",
        "TV",
        "Adventure",
        "Thriller",
        "Music",
        "Action",
        "Mystery",
        "Horror",
        "War",
        "Animation",
        "Movie",
        "Romance",
        "Family",
        "Crime"
    )
    var selectedGenres by remember { mutableStateOf(emptyList<String>()) }
    ChooseGenreScreen(
        genres = genres,
        pickedGenres = selectedGenres,
        onPickGenre = {
            selectedGenres = if (it in selectedGenres) selectedGenres - it else selectedGenres + it
        },
        onSubmit = {}
    )
}