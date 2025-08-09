package com.rach.newsappjetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rach.newsappjetpackcompose.model.Article
import com.rach.newsappjetpackcompose.model.Source
import com.rach.newsappjetpackcompose.theme.NewsAppJetPackComposeTheme
import com.rach.newsappjetpackcompose.ui.HomeScreen
import com.rach.newsappjetpackcompose.ui.SingleArticleUi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            NewsAppJetPackComposeTheme {
                HomeScreen()
            }
        }
    }
}

@Preview(showBackground = true , uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light Mode")
annotation class AppPreview