package com.example.book_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.book_screen.ui.theme.Book_screenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Book_screenTheme {
                BookScreen()
            }
        }
    }
}

@Composable
fun BookScreen() {
    Card(
        modifier = Modifier
            .fillMaxSize(),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            Column(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.book_1),
                    contentDescription = null,
                    modifier = Modifier.size(160.dp)
                )
            }
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Walk into the shadow By Estelle Darcy",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "By Estelle Darcy",
                    modifier = Modifier.padding(end = 6.dp),
                    style = TextStyle(fontSize = 15.sp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Last reading on 16/2/2025",
                    modifier = Modifier.padding(end = 6.dp),
                    style = TextStyle(fontSize = 15.sp)
                )

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Column (modifier = Modifier.padding(10.dp).padding(start = 24.dp)){
                Text("Read pages",fontSize = 22.sp,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.minus),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("12/345",fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(80.dp))

            Column (modifier = Modifier.padding(10.dp)){
                Text("Rating",fontSize = 22.sp,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.minus),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("0/5",fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }

            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.comment),
                contentDescription = null
                ,modifier = Modifier.size(30.dp)
            )
            Text("Comments",fontSize = 22.sp)

        }
        Card (modifier = Modifier.padding(8.dp)
            .height(200.dp).fillMaxWidth(),
            colors = CardDefaults.cardColors(
            containerColor = Color.Gray),
        ){
            Text("No comments yet,come to add some comment about book!"
                ,fontSize = 18.sp, lineHeight = 30.sp)
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.history),
                contentDescription = null
                ,modifier = Modifier.size(30.dp)
            )
            Text("Read History",fontSize = 22.sp)

        }
        Card (modifier = Modifier.padding(8.dp)
            .height(200.dp).fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.Gray),
        ){
            Column {
                Text("February 16, 2025"
                    ,fontSize = 18.sp, lineHeight = 30.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text("Read pages: 12 pages"
                    ,fontSize = 18.sp, lineHeight = 35.sp)
                Text("Read time: 00:05:05"
                    ,fontSize = 18.sp, lineHeight = 35.sp)
                Text("Add comment:"
                    ,fontSize = 18.sp, lineHeight = 35.sp)

            }

        }


    }
}



@Preview(showBackground = true)
@Composable
fun BookScreenPreview() {
    BookScreen()
}