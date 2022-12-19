package kz.arctan.movierecommendation.common.domain

import kotlin.random.Random

object TestData {
    fun getRandomStringList(
        size: Int,
        stringSizeRange: IntRange = 3..15
    ) = List(size) { generateRandomString(stringSizeRange) }

    fun generateRandomString(
        stringSizeRange: IntRange = 3..15
    ): String = List(stringSizeRange.random()) { Random.nextInt(32, 126).toChar() }.joinToString("")
}

