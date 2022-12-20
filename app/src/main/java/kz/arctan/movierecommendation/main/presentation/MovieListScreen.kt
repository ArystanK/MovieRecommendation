package kz.arctan.movierecommendation.main.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kz.arctan.movierecommendation.main.data.entity.Movie
import kz.arctan.movierecommendation.main.data.entity.MovieDto

@Composable
fun MovieListView(
    navController: NavController,
    moviesViewModel: MoviesViewModel,
) {
    val state by moviesViewModel.moviesState.collectAsState()
    val movies = if (state.movies.isNotEmpty()) state.movies.subList(1,
        state.movies.lastIndex) else emptyList()
    val topMovie = state.movies.firstOrNull() ?: MovieDto()
    MovieListScreen(
        movies = movies,
        topMovie = topMovie,
        onTopMovieClick = { /*TODO*/ },
        onMovieClick = {}
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieListScreen(
    movies: List<MovieDto>,
    topMovie: MovieDto,
    onTopMovieClick: () -> Unit,
    onMovieClick: (MovieDto) -> Unit,
) {
    Column {
        TextButton(onClick = onTopMovieClick, contentPadding = PaddingValues()) {
            MovieItemView(movie = topMovie)
        }
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
            items(movies) { movie ->
                TextButton(onClick = { onMovieClick(movie) }, contentPadding = PaddingValues()) {
                    MovieItemView(
                        movie = movie,
                    )
                }
            }
        }
    }
}

@Composable
fun MovieItemView(
    modifier: Modifier = Modifier,
    movie: MovieDto,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
//        AsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data(movie)
//                .crossfade(true)
//                .build(),
//            contentDescription = movie.title)
        Column(
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.5f))
                .padding(12.dp)
        ) {
            Text(movie.title, style = MaterialTheme.typography.h6)
            Text(
                text = movie.overview,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.caption
            )
        }
    }
}
