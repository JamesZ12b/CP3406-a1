package com.example.booktracker.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.booktracker.R

data class Book(
    @DrawableRes val imageResourceId: Int,
    @StringRes val author: Int,
    @StringRes val title: Int,
    val pages: Int
)

val books = listOf(
    Book(R.drawable.book_1, R.string.book_author_1,R.string.book_title_1,345),
    Book(R.drawable.book_2, R.string.book_author_2,R.string.book_title_2,567),
    Book(R.drawable.book_3, R.string.book_author_3,R.string.book_title_3,456)
)