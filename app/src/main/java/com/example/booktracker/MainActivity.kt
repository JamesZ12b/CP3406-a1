package com.example.booktracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.booktracker.data.Book
import com.example.booktracker.data.books
import com.example.booktracker.ui.theme.BookTrackerTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookTrackerTheme {
                BookTrackerApp()
            }
        }
    }
}

@Composable
fun BookTrackerApp() {
    var searchQuery by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(1f)) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(searchQuery) { query ->
                searchQuery = query
            }
            BookGrid(books, searchQuery) { book ->

            }
        }
        BottomNavBar()

    }
}

@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "search",
            modifier = Modifier.padding(8.dp)
        )
        TextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Text("Search books...", color = Color.Black.copy(alpha = 0.3f))
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface
            )
        )
    }
}

@Composable
fun BookGrid(books: List<Book>, searchQuery: String, onBookClick: (Book) -> Unit) {
    var showAddBookDialog by remember { mutableStateOf(false) }

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        columns = GridCells.Fixed(2),
    ) {
        items(books) { book ->
            BookCard(book = book, onClick = { onBookClick(book) })
        }
        item {
            AddBookCard(onClick = { showAddBookDialog = true  })
        }
    }
    if (showAddBookDialog) {
        AddBookDialog(
            onAddBook = { newBook ->
                // 处理添加书籍逻辑
                showAddBookDialog = false
            },
            onDismiss = { showAddBookDialog = false }
        )
    }
}


@Composable
fun BookCard(book: Book, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(260.dp, 280.dp)
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = book.imageResourceId),
                contentDescription = null,
                modifier = Modifier.size(160.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(book.title),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(text = "By ${stringResource(book.author)}",
                    modifier = Modifier.padding(end = 6.dp),
                    style = TextStyle(fontSize = 12.sp) )
                Text(text = "${book.read_pages}/${book.pages}",
                    style = TextStyle(fontSize = 12.sp) )
            }
        }
        }
}


@Composable
fun AddBookCard(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(260.dp, 280.dp)
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.add), contentDescription = "Add", modifier = Modifier.size(196.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Add book", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun AddBookDialog(onAddBook: (Book) -> Unit, onDismiss: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var pages by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add book") },
        text = {
            Column {
                TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
                TextField(value = author, onValueChange = { author = it }, label = { Text("Author") })
                TextField(value = pages, onValueChange = { pages = it }, label = { Text("Pages read") })
            }
        },
        confirmButton = {
            Button(onClick = {}) {
                Text("Save")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun BottomNavBar() {
    NavigationBar {
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.book),
                    contentDescription = null
                )
            },
            label = { Text("Books") },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.explore),
                    contentDescription = null
                )
            },
            label = { Text("Explore") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.goals),
                    contentDescription = null
                )
            },
            label = { Text("Goals") },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookTrackerPreview() {
    BookTrackerTheme {
        BookTrackerApp()
    }
}
