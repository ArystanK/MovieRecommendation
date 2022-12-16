package kz.arctan.movierecommendation.auth.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val username: String,
    val email: String,
    val firstname: String,
    val lastname: String,
    val friends: List<User>
) : Parcelable
