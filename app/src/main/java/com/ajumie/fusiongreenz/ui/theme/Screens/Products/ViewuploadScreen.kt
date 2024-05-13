package com.ajumie.fusiongreenz.ui.theme.Screens.Products

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ajumie.fusiongreenz.Data.productviewmodel
import com.ajumie.fusiongreenz.Navigations.ROUTE_UPDATE_PRODUCT
import com.ajumie.fusiongreenz.Navigations.ROUTE_VIEW_UPLOAD
import com.ajumie.fusiongreenz.models.Upload

@Composable
fun ViewUploadsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = productviewmodel(navController, context)


        val emptyUploadState = remember { mutableStateOf(Upload("","","","")) }
        var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

        var uploads = productRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All uploads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(uploads){
                    UploadItem(
                        name = it.name,
                        price = it.price,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }
        }
    }
}


@Composable
fun UploadItem(name:String,  price:String, imageUrl:String, id:String,
               navController: NavHostController, productRepository: productviewmodel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)

        Text(text = price)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_VIEW_UPLOAD+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}


