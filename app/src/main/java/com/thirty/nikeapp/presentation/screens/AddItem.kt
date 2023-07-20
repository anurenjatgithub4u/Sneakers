package com.thirty.nikeapp.presentation.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import kotlinx.coroutines.launch


@Composable
fun AddItemScreen(navController: NavController, ) {

    val scope = rememberCoroutineScope()
    val openDialog = remember { mutableStateOf(true) }


    if (openDialog.value){
        AlertDialog(modifier = Modifier.fillMaxWidth(),

            onDismissRequest = { navController.navigate("progress")

            },


            title = { Text(text = "Item Added to the Cart"
                , color = MaterialTheme.colorScheme.tertiary) },





            confirmButton = {


                TextButton(
                    onClick = {
                        scope.launch {
                            navController.popBackStack()

                        }

                    }
                ) {

                    Text("Ok", color = MaterialTheme.colorScheme.tertiary)
                }
            },



            containerColor = MaterialTheme.colorScheme.primary,


            textContentColor = Color.Black
        )
    }

}