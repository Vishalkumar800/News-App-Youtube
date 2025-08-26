package com.rach.newsappjetpackcompose.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rach.newsappjetpackcompose.model.Source
import kotlinx.serialization.SerialName

@Entity("articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int ,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source = Source(),
    val title: String ,
    val url: String ,
    val urlToImage: String
)
