package com.ajumie.fusiongreenz.Navigations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ajumie.fusiongreenz.ui.theme.LOGIN.Log
import com.ajumie.fusiongreenz.ui.theme.REGISTER.Register

import com.ajumie.fusiongreenz.ui.theme.Screens.Home.HScreen
import com.ajumie.fusiongreenz.ui.theme.Screens.MAIN.CategorySection
import com.ajumie.fusiongreenz.ui.theme.Screens.MAIN.ThemeScreen




import com.ajumie.fusiongreenz.ui.theme.Screens.Products.AddProductsScreen
import com.ajumie.fusiongreenz.ui.theme.Screens.Products.UpdateProductsScreen
import com.ajumie.fusiongreenz.ui.theme.Screens.Products.ViewProductsScreen
import com.ajumie.fusiongreenz.ui.theme.Screens.Products.ViewUploadsScreen
import com.ajumie.fusiongreenz.ui.theme.Screens.Splash.SplashScreen

//import com.ajumie.fusiongreenz.ui.theme.Screens.ThemeScreen


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun AppNavhost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(),
               startDestination:String= ROUTE_REGISTER ){
    NavHost(navController = navController, modifier = modifier, startDestination = startDestination){
//        composable(ROUTE_ADD_PRODUCT){
//        Register(navController)
//        }
        composable(ROUTE_REGISTER){
            Register(navController )
        }
        composable(ROUTE_LOGIN){
            Log(navController)
    }


        composable(ROUTE_MAINSCREEN){
            ThemeScreen(navController  )
        }

        composable(ROUTE_HOME){
           HScreen (navController )
        }

        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController )
        }
        composable(ROUTE_ADD_PRODUCT){
            AddProductsScreen(navController )
        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductsScreen(navController  )
        }

        composable(ROUTE_SPLASH){
            SplashScreen(navController )
        }
        composable(ROUTE_UPDATE_PRODUCT+ "/{id}"){passedData ->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }

    }}

