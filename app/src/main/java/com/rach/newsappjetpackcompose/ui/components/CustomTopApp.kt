package com.rach.newsappjetpackcompose.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    onSearchIconClick:() -> Unit = {},
    onHomeIconClicked:() -> Unit = {},
    onBackArrowClick:() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
        ),
        navigationIcon = {
            if (title == "Home") {
                IconButton(
                    onClick = onHomeIconClicked
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "TopAppBar Menu Icon"
                    )
                }
            } else {
                IconButton(
                    onClick = onBackArrowClick
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "ArrowBack Icon"
                    )
                }
            }
        },
        actions = {
            if (title == "Home") {
                IconButton(
                    onClick = onSearchIconClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                }
            }
        }
    )
}