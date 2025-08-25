package com.rach.newsappjetpackcompose.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    Converters::class
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getArticle(): ArticleDao

    companion object{

        @Volatile
        private var instance : AppDatabase? = null

        operator fun invoke(context: Context): AppDatabase{
            return instance ?: synchronized(this){
                instance ?: createDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun createDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "article.db"
            ).build()
        }
    }
}

