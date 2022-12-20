package kz.arctan.movierecommendation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kz.arctan.movierecommendation.login.presentation.LoginView
import kz.arctan.movierecommendation.login.presentation.LoginViewModel
import kz.arctan.movierecommendation.main.presentation.ChooseGenreView
import kz.arctan.movierecommendation.main.presentation.ChooseGenreViewModel
import kz.arctan.movierecommendation.register.presentation.RegistrationView
import kz.arctan.movierecommendation.register.presentation.RegistrationViewModel
import kz.arctan.movierecommendation.ui.theme.MovieRecommendationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieRecommendationTheme {
//                MovieListScreen(
//                    movies = listOf(
//                        Movie(
//                            title = "Interstellar",
//                            description = "jdgfiosbdnfmdso;fgrsioghreopvmdsl;kvnfdskgnrdsfklgfmndjklsbgirfsfngvoedbhgiusrfjkevbnklfedangkjrfdsnvblkadegbjkdrfnvjkldsbgjkredafnvliedfgerjkldsnfilsdkghioedrhgriolegnriledskgbhkfuedjgildfgfdhgnedrfile",
//                            genres = listOf(),
//                            image = "https://cdn.vox-cdn.com/thumbor/yHpuduOqZvdnlXssDTv7nNNJdUk=/44x0:3427x2255/1400x1400/filters:focal(44x0:3427x2255):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/43539058/interstellar.0.0.jpg"
//                        ),
//                        Movie(
//                            title = "Interstellar",
//                            description = "jdgfiosbdnfmdso;fgrsioghreopvmdsl;kvnfdskgnrdsfklgfmndjklsbgirfsfngvoedbhgiusrfjkevbnklfedangkjrfdsnvblkadegbjkdrfnvjkldsbgjkredafnvliedfgerjkldsnfilsdkghioedrhgriolegnriledskgbhkfuedjgildfgfdhgnedrfile",
//                            genres = listOf(),
//                            image = "https://cdn.vox-cdn.com/thumbor/yHpuduOqZvdnlXssDTv7nNNJdUk=/44x0:3427x2255/1400x1400/filters:focal(44x0:3427x2255):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/43539058/interstellar.0.0.jpg"
//                        ),
//                        Movie(
//                            title = "Interstellar",
//                            description = "jdgfiosbdnfmdso;fgrsioghreopvmdsl;kvnfdskgnrdsfklgfmndjklsbgirfsfngvoedbhgiusrfjkevbnklfedangkjrfdsnvblkadegbjkdrfnvjkldsbgjkredafnvliedfgerjkldsnfilsdkghioedrhgriolegnriledskgbhkfuedjgildfgfdhgnedrfile",
//                            genres = listOf(),
//                            image = "https://cdn.vox-cdn.com/thumbor/yHpuduOqZvdnlXssDTv7nNNJdUk=/44x0:3427x2255/1400x1400/filters:focal(44x0:3427x2255):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/43539058/interstellar.0.0.jpg"
//                        ),
//                        Movie(
//                            title = "Interstellar",
//                            description = "jdgfiosbdnfmdso;fgrsioghreopvmdsl;kvnfdskgnrdsfklgfmndjklsbgirfsfngvoedbhgiusrfjkevbnklfedangkjrfdsnvblkadegbjkdrfnvjkldsbgjkredafnvliedfgerjkldsnfilsdkghioedrhgriolegnriledskgbhkfuedjgildfgfdhgnedrfile",
//                            genres = listOf(),
//                            image = "https://cdn.vox-cdn.com/thumbor/yHpuduOqZvdnlXssDTv7nNNJdUk=/44x0:3427x2255/1400x1400/filters:focal(44x0:3427x2255):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/43539058/interstellar.0.0.jpg"
//                        ),
//                        Movie(
//                            title = "Interstellar",
//                            description = "jdgfiosbdnfmdso;fgrsioghreopvmdsl;kvnfdskgnrdsfklgfmndjklsbgirfsfngvoedbhgiusrfjkevbnklfedangkjrfdsnvblkadegbjkdrfnvjkldsbgjkredafnvliedfgerjkldsnfilsdkghioedrhgriolegnriledskgbhkfuedjgildfgfdhgnedrfile",
//                            genres = listOf(),
//                            image = "https://cdn.vox-cdn.com/thumbor/yHpuduOqZvdnlXssDTv7nNNJdUk=/44x0:3427x2255/1400x1400/filters:focal(44x0:3427x2255):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/43539058/interstellar.0.0.jpg"
//                        ),
//                        Movie(
//                            title = "Interstellar",
//                            description = "jdgfiosbdnfmdso;fgrsioghreopvmdsl;kvnfdskgnrdsfklgfmndjklsbgirfsfngvoedbhgiusrfjkevbnklfedangkjrfdsnvblkadegbjkdrfnvjkldsbgjkredafnvliedfgerjkldsnfilsdkghioedrhgriolegnriledskgbhkfuedjgildfgfdhgnedrfile",
//                            genres = listOf(),
//                            image = "https://cdn.vox-cdn.com/thumbor/yHpuduOqZvdnlXssDTv7nNNJdUk=/44x0:3427x2255/1400x1400/filters:focal(44x0:3427x2255):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/43539058/interstellar.0.0.jpg"
//                        ),
//                    ),
//                    topMovie = Movie(
//                        title = "Interstellar",
//                        description = "jdgfiosbdnfmdso;fgrsioghreopvmdsl;kvnfdskgnrdsfklgfmndjklsbgirfsfngvoedbhgiusrfjkevbnklfedangkjrfdsnvblkadegbjkdrfnvjkldsbgjkredafnvliedfgerjkldsnfilsdkghioedrhgriolegnriledskgbhkfuedjgildfgfdhgnedrfile",
//                        genres = listOf(),
//                        image = "https://cdn.vox-cdn.com/thumbor/yHpuduOqZvdnlXssDTv7nNNJdUk=/44x0:3427x2255/1400x1400/filters:focal(44x0:3427x2255):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/43539058/interstellar.0.0.jpg"
//                    ),
//                    onTopMovieClick = { /*TODO*/ },
//                    onMovieClick = {}
//                )
                App()
            }
        }
    }
}

@Composable
fun App() {
    MovieRecommendationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.LoginView) {
                composable(Routes.LoginView) {
                    val loginViewModel = hiltViewModel<LoginViewModel>()
                    LoginView(viewModel = loginViewModel, navController = navController)
                }
                composable(Routes.RegistrationView) {
                    val registrationViewModel = hiltViewModel<RegistrationViewModel>()
                    RegistrationView(
                        viewModel = registrationViewModel,
                        navController = navController
                    )
                }
                composable(Routes.ChooseGenreView) {
                    val chooseGenreViewModel = hiltViewModel<ChooseGenreViewModel>()
                    ChooseGenreView(viewModel = chooseGenreViewModel, navController = navController)
                }
            }
        }
    }
}