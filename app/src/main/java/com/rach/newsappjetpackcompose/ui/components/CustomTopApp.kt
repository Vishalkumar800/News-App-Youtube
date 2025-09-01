package com.rach.newsappjetpackcompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.rach.newsappjetpackcompose.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    title: String?,
    onSearchIconClick: () -> Unit = {},
    onHomeIconClicked: () -> Unit = {},
    onBackArrowClick: () -> Unit = {},
    userSearchQuery: (String) -> Unit = {}

) {

    var isSearchActive by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            if (title == Screens.SearchScreen.route && isSearchActive) {
                TextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                        userSearchQuery(it)
                    },
                    placeholder = { Text("Search Here") },
                    modifier = Modifier.fillMaxWidth()
                )

            } else {
                if (!title.isNullOrEmpty()) {
                    Text(title)
                }
            }
        },
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
                    onClick = {
                        if (isSearchActive) {
                            isSearchActive = false
                            searchQuery = ""
                        } else {
                            onBackArrowClick()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "ArrowBack Icon"
                    )
                }
            }
        },
        actions = {
            if (title in listOf(Screens.HomeScreen.route , Screens.SearchScreen.route) ) {
                IconButton(
                    onClick = {
                        if (title == Screens.SearchScreen.route){
                            isSearchActive = true
                        }else{
                            onSearchIconClick()
                        }
                    }
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
