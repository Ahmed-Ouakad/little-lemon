package com.example.littlelemon

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Onboarding(navController: NavHostController? = null,sharedPreferences: SharedPreferences? = null ){

    var firstNameValue by remember {
        mutableStateOf("")
    }
    var lastNameValue by remember {
        mutableStateOf("")
    }
    var emailValue by remember {
        mutableStateOf("")
    }
Column() {
    val context = LocalContext.current
    Header()
    Box(
        modifier = Modifier
            .height(150.dp)
            .padding(top = 10.dp)
            .fillMaxWidth(1f)
            .background(color = LittleLemonColor.green),
        contentAlignment = Alignment.Center,



    ) {
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(R.string.knowYou),
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.Center),
            color = LittleLemonColor.cloud,
            fontSize = 30.sp
        )

    }
    Text(
        textAlign = TextAlign.Start,
        text = stringResource(R.string.personalInfo),
        modifier = Modifier.padding(start = 10.dp, top = 20.dp, bottom = 20.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        textAlign = TextAlign.Start,
        text = "First name",
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 10.dp)
    )
    OutlinedTextField(
        value = firstNameValue,
        onValueChange = { newText ->
            firstNameValue = newText
        },
        placeholder = { Text(text = "Enter your first name") },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
    )
    Text(
        text = "Last name",
        textAlign = TextAlign.Start,
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 10.dp)

        )
    OutlinedTextField(
        value = lastNameValue,
        onValueChange = { newText ->
            lastNameValue = newText
        },
        placeholder = { Text(text = "Enter your last name") },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
    )
    Text(
        text = "Email",
        textAlign = TextAlign.Start,
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 10.dp)

    )
    OutlinedTextField(
        value = emailValue,
        onValueChange = { newText ->
            emailValue = newText
        },
        placeholder = { Text(text = "Enter your last name") },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)

    )
    Button(onClick = {
        if (!firstNameValue.isBlank()&& !lastNameValue.isBlank()&& !emailValue.isBlank()){
            sharedPreferences!!.edit()
                .putString("firstName",firstNameValue)
                .putString("lastName",lastNameValue)
                .putString("email",emailValue)
                .commit()
            Toast.makeText(context,"Registration successful !!",Toast.LENGTH_SHORT).show()
            navController?.navigate(Home.route)
        }else
        Toast.makeText(context,"Registration not successful please enter all values ",Toast.LENGTH_SHORT).show()

                     },
        modifier = Modifier.fillMaxWidth(1f)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            //.clip(shape = RoundedCornerShape(20.dp))
    ) {
        Text(text = "Register", fontSize = 15.sp, color = LittleLemonColor.charcoal)
    }
}
}

@Composable
fun Header(){
    Image(painter = painterResource(id = R.drawable.logo) ,
        contentDescription = "logo",
        modifier = Modifier
            .fillMaxWidth(1f)
            .size(size = 80.dp)
            .padding(top = 20.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    Onboarding()
}