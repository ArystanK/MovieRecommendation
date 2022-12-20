package kz.arctan.movierecommendation.common.data

sealed interface LetsSeeResult<T> {
    data class Init<T>(val data: T? = null) : LetsSeeResult<T>
    data class Success<T>(val data: T) : LetsSeeResult<T>
    data class Loading<T>(val data: T? = null) : LetsSeeResult<T>
    data class Error<T>(val message: String, val data: T? = null) : LetsSeeResult<T>
}