package com.example.booktracker.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.booktracker.R

data class Book(
    @DrawableRes val imageResourceId: Int,
    @StringRes val author: Int,
    @StringRes val title: Int,
    val read_pages: Int,
    val pages: Int
)

val books = listOf(
    Book(R.drawable.book_1, R.string.book_author_1,R.string.book_title_1,12,345),
    Book(R.drawable.book_2, R.string.book_author_2,R.string.book_title_2,56,567),
    Book(R.drawable.book_3, R.string.book_author_3,R.string.book_title_3,102,456) ,
    Book(R.drawable.book_4, R.string.book_author_4,R.string.book_title_4,1,789)
)