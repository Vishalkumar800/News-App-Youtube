package com.rach.newsappjetpackcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
        Row {
            Column {
                AsyncImage(
                    model = article.urlToImage,
                    contentDescription = "Api Image",
                    modifier = Modifier.size(width = 160.dp, height = 90.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.ic_launcher_foreground)
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = article.source.name
                )
                Text(
                    text = article.publishedAt
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column {
                //Title
                Text(
                    text = article.title,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        lineHeight = 18.sp
                    ),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                //Description
                Text(
                    text = article.description,
                    style = TextStyle(
                        lineHeight = 18.sp
                    ),
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
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
            article = Article(
                title = stringResource(R.string.title),
                description = stringResource(R.string.description),
                source = Source(
                    name = "Aaj Tak"
                ),
                publishedAt = "12/3/2025"
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
