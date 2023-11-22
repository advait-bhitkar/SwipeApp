import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.swipeapp.presentation.screens.addProduct.AddProduct
import com.example.swipeapp.presentation.screens.addProduct.AddProductViewModel
import com.example.swipeapp.presentation.screens.productList.ProductList
import com.example.swipeapp.presentation.screens.productList.ProductListViewModel
import com.example.swipeapp.utils.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, Screen.ProductListScreen.route) {
        composable(Screen.ProductListScreen.route) {
            val viewModel = getViewModel<ProductListViewModel>()
            ProductList(viewModel, navController)
        }
        composable(Screen.AddProductScreen.route) {
            val viewModel = getViewModel<AddProductViewModel>()
            AddProduct(viewModel, navController)
        }
    }
}
