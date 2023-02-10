package com.example.littlelemon

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Profile(navController: NavHostController? = null,sharedPreferences: SharedPreferences?= null){
Column {
    var firstNameValue by remember {
        mutableStateOf(sharedPreferences?.getString("firstName","no first name"))
    }
    var lastNameValue by remember {
        mutableStateOf(sharedPreferences?.getString("lastName","no last name"))
    }
    var emailValue by remember {
        mutableStateOf(sharedPreferences?.getString("email","no email"))
    }
    Header()
    Text(text = "Profile information")
    Text(
        textAlign = TextAlign.Start,
        text = "First name",
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 10.dp)
    )
    OutlinedTextField(
        value = firstNameValue!!,
        onValueChange = { newText ->
            firstNameValue = newText
        },
        placeholder = { Text(text = "Enter your first name") },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        enabled = false
    )
    Text(
        text = "Last name",
        textAlign = TextAlign.Start,
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 10.dp)

    )
    OutlinedTextField(
        value = lastNameValue!!,
        onValueChange = { newText ->
            lastNameValue = newText
        },
        placeholder = { Text(text = "Enter your last name") },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        enabled = false
    )
    Text(
        text = "Email",
        textAlign = TextAlign.Start,
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 10.dp)

    )
    OutlinedTextField(
        value = emailValue!!,
        onValueChange = { newText ->
            emailValue = newText
        },
        placeholder = { Text(text = "Enter your last name") },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
        enabled = false

    )
    Button(onClick = {
        sharedPreferences!!.edit().clear()
            .commit()
        navController?.navigate(Onboarding.route)
    },
        modifier = Modifier.fillMaxWidth(1f)
            .padding(horizontal = 15.dp, vertical = 20.dp)
        //.clip(shape = RoundedCornerShape(20.dp))
    ) {
        Text(text = "Log out", fontSize = 15.sp, color = LittleLemonColor.charcoal)
    }
}
}
