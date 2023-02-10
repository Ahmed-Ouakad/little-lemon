package com.example.littlelemon

import android.media.Image
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    @SerialName("menu")
    val menu: List<MenuItemNetwork>,
)

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("price")
    val price: Double,

    @SerialName("description")
    val description: String,

    @SerialName("image")
    val image: String,

    @SerialName("category")
    val category: String,
){
    fun toMenuItemRoom() = MenuItemRoom(
        // add code here
        id = id,
        title = title,
        price = price,
        description = description,
        image = image,
        category = category
    )
}