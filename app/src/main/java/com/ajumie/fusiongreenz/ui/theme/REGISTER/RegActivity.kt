package com.ajumie.fusiongreenz.ui.theme.REGISTER

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import com.ajumie.fusiongreenz.Navigations.ROUTE_LOGIN
import com.ajumie.fusiongreenz.Navigations.ROUTE_MAINSCREEN
import com.ajumie.fusiongreenz.Navigations.ROUTE_REGISTER
import com.ajumie.fusiongreenz.R
import com.ajumie.fusiongreenz.ui.theme.Orange
import com.ajumie.fusiongreenz.ui.theme.Pink40
import com.ajumie.fusiongreenz.ui.theme.Pink80
import com.ajumie.fusiongreenz.ui.theme.cream


@Composable
fun Register (navController: NavHostController){
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue(""))}
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }


    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
//            .padding(20.dp)
            .paint(
                painterResource(id = R.drawable.mumamazzz),
                contentScale = ContentScale.FillBounds
            )
    ) {


            Text(
                text = "FUSIONGREENZ",
                color = Color.Red,
                fontSize = 40.sp,
                fontFamily = FontFamily.Cursive
            )
            Icon(imageVector = Icons.Default.Person, contentDescription = "person")

            OutlinedTextField(
                value = confirmpass,
                onValueChange = { confirmpass = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "person"
                    )
                },
                label = {
                    Text(
                        text = "Confirm password",
                        color = Color.LightGray,
                    )
                },


                modifier = Modifier
//                .fillMaxWidth()

                    .padding(vertical = 8.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "email"
                    )
                },
                label = {
                    Text(
                        text = "Email Address",
                        color = Color.LightGray,
                    )
                },
                modifier = Modifier
//                .fillMaxWidth()

            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password"
                    )
                },
                label = {
                    Text(
                        text = "Your Password",
                        color = Color.LightGray,
                    )
                },


                modifier = Modifier
//                .fillMaxWidth()
                    .padding(vertical = 8.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions()
            )








            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {

                  val myregister= AuthViewModel(navController,context)
                 myregister.signup(email.text.trim(), password.text.trim(), confirmpass .text.trim())
                navController.navigate(ROUTE_MAINSCREEN)
            }, modifier = Modifier.width(120.dp),
                colors = ButtonDefaults.buttonColors(Pink40)) {
                Text(
                    text = "Sign Up",
                    color = Color.LightGray,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navController.navigate(ROUTE_LOGIN)
            }, modifier = Modifier.width(400.dp),
                colors = ButtonDefaults.buttonColors(Pink40)
            ) {
                Text(
                    text = "Have an Account? Click to Login",
                    color = Color.LightGray,
                )
            }
        }

    }







@Preview
@Composable
 fun registerprev() {
    Register(navController = rememberNavController())
}