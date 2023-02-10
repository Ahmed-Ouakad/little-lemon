package com.example.littlelemon

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationComposable (navController: NavHostController,isLoggedIn : Boolean, sharedPreferences: SharedPreferences? = null, menuItems : List<MenuItemRoom>){

    var startDes by remember {
        if(isLoggedIn){
            mutableStateOf(Onboarding.route)
        }else
            mutableStateOf(Home.route)
    }

NavHost(navController = navController, startDestination = startDes ){
    composable(Home.route){
        Home(navController,menuItems)
    }
    composable(Onboarding.route){
        Onboarding(navController,sharedPreferences)
    }
    composable(Profile.route){
        Profile(navController,sharedPreferences)
    }
}
}