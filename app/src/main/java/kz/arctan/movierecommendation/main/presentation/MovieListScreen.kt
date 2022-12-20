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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kz.arctan.movierecommendation.main.data.entity.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieListScreen(
    movies: List<Movie>,
    topMovie: Movie,
    onTopMovieClick: () -> Unit,
    onMovieClick: (Movie) -> Unit,
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
    movie: Movie,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(movie.image)
                .crossfade(true)
                .build(),
            contentDescription = movie.title)
        Column(
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.5f))
                .padding(12.dp)
        ) {
            Text(movie.title, style = MaterialTheme.typography.h6)
            Text(
                text = movie.description,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview
@Composable
fun MovieItemViewPreview() {
    MovieItemView(
        movie = Movie(
            title = "Interstellar",
            description = "jdgfiosbdnfmdso;fgrsioghreopvmdsl;kvnfdskgnrdsfklgfmndjklsbgirfsfngvoedbhgiusrfjkevbnklfedangkjrfdsnvblkadegbjkdrfnvjkldsbgjkredafnvliedfgerjkldsnfilsdkghioedrhgriolegnriledskgbhkfuedjgildfgfdhgnedrfile",
            genres = listOf(),
            image = "https://cdn.vox-cdn.com/thumbor/yHpuduOqZvdnlXssDTv7nNNJdUk=/44x0:3427x2255/1400x1400/filters:focal(44x0:3427x2255):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/43539058/interstellar.0.0.jpg"
        )
    )
}
