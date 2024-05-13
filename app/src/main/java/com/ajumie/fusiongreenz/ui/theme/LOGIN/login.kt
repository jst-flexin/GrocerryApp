package com.ajumie.fusiongreenz.ui.theme.LOGIN

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ajumie.fusiongreenz.Data.AuthViewModel
import com.ajumie.fusiongreenz.Navigations.ROUTE_HOME
import com.ajumie.fusiongreenz.Navigations.ROUTE_MAINSCREEN
import com.ajumie.fusiongreenz.Navigations.ROUTE_REGISTER
import com.ajumie.fusiongreenz.R
import com.ajumie.fusiongreenz.ui.theme.Orange
import com.ajumie.fusiongreenz.ui.theme.Pink40


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun Log (navController: NavHostController) {


    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }

    val context= LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Orange)
            .paint(
                painterResource(id = R.drawable.mumamazzz),
                contentScale = ContentScale.FillBounds
            )


    ) {
        Text(
            text = "",
            color = Color.Green,
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp

        )

        Icon(imageVector = Icons.Default.Person, contentDescription = "person")


        OutlinedTextField(
            value =email ,
            onValueChange ={email=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="email" ) },
            label = { Text(text = "Email Address",
                color = Color.LightGray,)
                    },

            modifier = Modifier
                .width(300.dp)

        )

        OutlinedTextField(
            value =pass ,
            onValueChange ={pass=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="password" ) },
            label = { Text(text = "Your Password",
                color = Color.LightGray,) },


            modifier = Modifier
                .width(300.dp)
                .padding(vertical = 16.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions()
        )

        Button(
            onClick = {

            val mylogin= AuthViewModel(navController, context  )
                mylogin.login(email.text.trim(),pass.text.trim())

                navController.navigate(ROUTE_HOME)


            },
            modifier = Modifier.width(120.dp),
            colors = ButtonDefaults.buttonColors(Pink40)
        ) {
            Text(text = "LOGIN ",
                color = Color.LightGray,)
        }
        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)
        }, modifier = Modifier.width(300.dp),
            colors = ButtonDefaults.buttonColors(Pink40)) {
            Text(text = "Don't have account? Click to Register",
                color = Color.LightGray,)
        }
    }





}

@RequiresApi(Build.VERSION_CODES.P)
@Preview
@Composable
private fun Loginprev() {
    Log(navController = rememberNavController() )

}