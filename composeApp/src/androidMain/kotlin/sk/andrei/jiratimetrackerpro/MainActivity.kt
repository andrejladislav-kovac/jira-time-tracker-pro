package sk.andrei.jiratimetrackerpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import sk.andrei.jiratimetrackerpro.presentation.feature.root.RootComponentImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val rootComponent = RootComponentImpl(defaultComponentContext())

        setContent {
            App(rootComponent)
        }
    }
}