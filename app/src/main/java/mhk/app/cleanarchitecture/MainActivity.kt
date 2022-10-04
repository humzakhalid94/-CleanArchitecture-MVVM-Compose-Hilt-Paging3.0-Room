package mhk.app.cleanarchitecture

//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mhk.app.cleanarchitecture.presentation.navigation.NavGraph
import mhk.app.cleanarchitecture.ui.theme.AndroidCleanArchitectureTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCleanArchitectureTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}