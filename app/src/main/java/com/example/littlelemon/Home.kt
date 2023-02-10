package com.example.littlelemon

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Home(navController: NavHostController? = null,menuItems : List<MenuItemRoom>){

    Column(modifier = Modifier.fillMaxWidth(1f)) {

       val context= LocalContext.current


        Row() {
            Image(painter = painterResource(id = R.drawable.logo) ,
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .size(size = 80.dp)
                    .padding(top = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.my_profil) ,
                contentDescription = "profile",
                modifier = Modifier
                    .size(size = 80.dp)
                    .padding(top = 20.dp)
                    .clickable {
                        navController?.navigate(Profile.route)
                        Toast
                            .makeText(context, "you pressed me !!!", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Button(onClick = {
                navController?.navigate(Onboarding.route)
            },

            ) {
                Text(text = "L", fontSize = 15.sp, color = LittleLemonColor.charcoal)
            }
        }
        Hero()
        WeeklySpecialCard()
        MenuItemsList(items = menuItems)

    }

}
@Composable
fun Hero(){
    var searchValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .background(color = LittleLemonColor.green)
            .fillMaxWidth(1f)
    ) {
        Text(
            text = "Little Lemon",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.yellow,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = "Chicago",
            fontSize = 20.sp,
            color = LittleLemonColor.cloud,
            modifier = Modifier.padding(start = 10.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 20.dp)
        ) {
            Text(
                text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                style = MaterialTheme.typography.body1,
                color = LittleLemonColor.cloud,
                modifier = Modifier
                    .padding(bottom = 28.dp, end = 20.dp, start = 10.dp)
                    .fillMaxWidth(0.6f)
            )
            Image(

                painter = painterResource(id = R.drawable.hero_image),
                contentScale = ContentScale.Crop,
                contentDescription = "Hero Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(end = 10.dp)

            )
        }

       TextField(value = searchValue , onValueChange = {newVal -> searchValue = newVal},

           modifier = Modifier
               .padding(10.dp)
               .fillMaxWidth(1f)
               .background(LittleLemonColor.cloud),
           placeholder = { Text(text = "Enter search phrase", fontSize = 15.sp) }

       )

    }
}
@Composable
fun WeeklySpecialCard() {
    val categories : Array<String> = arrayOf(" Starters","Mains","Dessert","Drinks")
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            text = "Order for delivery",

            modifier = Modifier
                .padding(8.dp)
        )

        LazyRow{

                itemsIndexed(categories){_,category ->
                    itemCategory(category = category)
                }


        }
        Divider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            thickness = 1.dp,
            color = LittleLemonColor.cloud
        )
    }
}
@Composable
fun itemCategory(category: String){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = LittleLemonColor.cloud),
        modifier = Modifier.padding(5.dp)
    )
    {
        Text(
            text = category,
        )
    }
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun MenuItemsList(items: List<MenuItemRoom>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 20.dp)
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column {
                        Text(
                            text = menuItem.title,
                            style = MaterialTheme.typography.h2
                        )
                        Text(
                            text = menuItem.description,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp)
                                .fillMaxWidth(.75f)
                        )
                        Text(
                            text = "$${menuItem.price}",
                            style = MaterialTheme.typography.body2,
                        )
                    }

                    GlideImage(model = menuItem.image, contentDescription = "",modifier = Modifier.clip(RoundedCornerShape(10.dp)))
                }
                Divider(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    thickness = 1.dp,
                    color = LittleLemonColor.yellow
                )
            }

        )
    }
}
