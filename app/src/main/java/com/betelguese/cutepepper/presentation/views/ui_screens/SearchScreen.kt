package com.betelguese.cutepepper.presentation.views.ui_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.betelguese.cutepepper.presentation.views.ui_elements.CategoryCard
import com.betelguese.cutepepper.presentation.views.ui_elements.customcolor
import com.betelguese.cutepepper.presentation.views.ui_elements.customelevation


data class SearchResult(
    val id: Int,
    val name: String
)

var mylist = listOf<SearchResult>(
    SearchResult(45, "Raghu"),
    SearchResult(45, "some name"),
    SearchResult(67, "praksy"),
    SearchResult(67, "sarav"),
    SearchResult(54, "neeri"),
    SearchResult(54, "lux"),
    SearchResult(78, "master"),
    SearchResult(34, "beast"),
    SearchResult(67, "Zilla"),
    SearchResult(45, "ragi"),
    SearchResult(45, "wheat"),
    SearchResult(78, "rice"),
    SearchResult(87, "jokeru"),
    SearchResult(87, "joky"),
    SearchResult(78, "swathi"),
    SearchResult(34, "bhuvi"),
)

@Composable
fun SearchscreenUI() {
    val listy =  listOf(
        45, 67, 87, 54, 45, 34, 78
    )
    Surface(
        color = MaterialTheme.customcolor.ScreenBackground700,
        elevation = MaterialTheme.customelevation.normal,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var result by remember {
            mutableStateOf(mylist)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BackTopBar()
            Divider(thickness = 1.dp, color = Color.White.copy(0.6f))
//            Catlist(
//                list = listOf(
//                    45, 67, 87, 54, 45, 34, 78
//                )
//            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                itemsIndexed(listy) { _, item ->
                    CategoryCard(
                        onclick ={
                            result = SearchList(item)
                        },
                        itemName = item.toString()
                    )
                }
            }
            Divider(thickness = 1.dp, color = Color.White.copy(0.6f))
            LazyColumn(
            modifier = Modifier
                    .fillMaxWidth()){
                    itemsIndexed(result){ _,item ->
                    CategoryCard(onclick = { /*TODO*/ },
                        itemName = item.name )
                }
            }
        }
    }
}

@Composable
fun Catlist(list: List<Int>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        itemsIndexed(list) { _, item ->
            CategoryCard(
                onclick ={

                },
                itemName = item.toString()
            )
        }
    }
}
fun SearchList(idx: Int) : List<SearchResult> {
    return mylist.filter {
        it.id == idx
    }
}
@Preview(showBackground = true)
@Composable
fun UIPrev() {
    SearchscreenUI()
}
