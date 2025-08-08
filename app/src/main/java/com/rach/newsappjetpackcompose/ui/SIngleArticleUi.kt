package com.rach.newsappjetpackcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rach.newsappjetpackcompose.AppPreview
import com.rach.newsappjetpackcompose.R
import com.rach.newsappjetpackcompose.model.Article
import com.rach.newsappjetpackcompose.model.Source
import com.rach.newsappjetpackcompose.theme.NewsAppJetPackComposeTheme

@Composable
fun SingleArticleUi(
    modifier: Modifier = Modifier,
    article: Article,
) {

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                AsyncImage(
                    model = R.drawable.choti,
                    contentDescription = "Article Image",
                    modifier = Modifier.size(width = 160.dp, height = 90.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = article.source.name,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = article.publishedAt
                )
            }
            //
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = article.title,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        lineHeight = 18.sp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = article.description,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        lineHeight = 18.sp
                    )
                )
            }

        }


    }

}

@AppPreview
@Composable
private fun Preview() {
    NewsAppJetPackComposeTheme {
        SingleArticleUi(
            modifier = Modifier.fillMaxWidth(),
            article = Article(
                title = " AsyncImage is a composable that executes an image request asynchronously and renders the result. It supports the same arguments as the standard Image composable and additionally, it",
                description = "AsyncImage is a composable that executes an image request asynchronously and renders the result. It supports the same arguments as the standard Image composable and additionally, it , AsyncImage is a composable that executes an image request asynchronously and renders the result. It supports the same arguments as the standard Image composable and additionally, it",
                source = Source(
                    id = "727",
                    name = "Aaj Tak"
                ),
                publishedAt = "12/9/2026"
            )
        )
    }
}