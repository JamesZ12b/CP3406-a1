package com.example.booktracker.ui

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.example.booktracker.data.Book
import com.example.booktracker.data.books

class BookTrackerViewModel : ViewModel() {

    // 书籍列表（也可以从网络或数据库动态加载）
    private val _books = mutableStateOf(books)
    val booksState get() = _books.value

    // 搜索关键字
    var searchQuery = mutableStateOf("")

    // 控制“添加书籍”弹窗是否显示
    var showAddBookDialog = mutableStateOf(false)

    /**
     * 更新搜索关键字
     */
    fun updateSearchQuery(newQuery: String) {
        searchQuery.value = newQuery
    }

    /**
     * 点击添加书籍后显示对话框
     */
    fun onAddBookClick() {
        showAddBookDialog.value = true
    }

    /**
     * 处理添加书籍逻辑
     */
    fun addBook(newBook: Book) {
        // 假设此处做插入数据库或网络操作
        _books.value = _books.value + newBook

        // 隐藏对话框
        showAddBookDialog.value = false
    }

    /**
     * 取消添加书籍对话框
     */
    fun cancelAddBook() {
        showAddBookDialog.value = false
    }
}