package com.hien.mykmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hien.mykmm.android.ui.DetailScreen
import com.hien.mykmm.android.ui.RocketScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "list") {
                composable("list") {
                    RocketScreen(navigateToDetails = { objectId ->
                        navController.navigate("details/$objectId")
                    })
                }
                composable(
                    "details/{objectId}",
                    arguments = listOf(navArgument("objectId") { type = NavType.IntType })
                ) { backstack ->
                    DetailScreen(
                        objectId = backstack.arguments?.getInt("objectId")!!,
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
