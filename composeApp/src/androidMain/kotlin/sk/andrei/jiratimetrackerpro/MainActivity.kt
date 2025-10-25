package sk.andrei.jiratimetrackerpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import sk.andrei.jiratimetrackerpro.presentation.feature.root.component.RootComponentImpl
import sk.andrei.jiratimetrackerpro.presentation.feature.root.ui.RootScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val rootComponent = RootComponentImpl(defaultComponentContext())

        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                RootScreen(
                    modifier = Modifier,
                    component = rootComponent,
                    innerPadding = innerPadding
                )
            }
        }
    }
}