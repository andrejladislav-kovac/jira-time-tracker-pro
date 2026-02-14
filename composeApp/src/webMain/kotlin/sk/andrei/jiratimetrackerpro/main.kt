package sk.andrei.jiratimetrackerpro

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher
import kotlinx.browser.document
import org.koin.core.context.startKoin
import org.w3c.dom.Document
import sk.andrei.jiratimetrackerpro.data.dataModules
import sk.andrei.jiratimetrackerpro.domain.domainModule
import sk.andrei.jiratimetrackerpro.presentation.feature.root.component.RootComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.root.component.RootComponentImpl
import sk.andrei.jiratimetrackerpro.presentation.feature.root.ui.RootScreen
import kotlin.collections.plus

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    startKoin {
        modules(dataModules + domainModule)
    }

    val rootComponent = createRootComponent()

    ComposeViewport {
        RootScreen(
            modifier = Modifier,
            component = rootComponent,
        )
    }
}

fun createRootComponent(): RootComponent {
    val lifecycle = LifecycleRegistry()

    //val stateKeeper = StateKeeperDispatcher(savedState = localStorage[KEY_SAVED_STATE]?.decodeSerializableContainer())
    val stateKeeper = StateKeeperDispatcher()

    val root = RootComponentImpl(DefaultComponentContext(lifecycle = lifecycle, stateKeeper = stateKeeper))

    lifecycle.attachToDocument()

//    window.onbeforeunload =
//        {
//            localStorage[KEY_SAVED_STATE] = stateKeeper.save().encodeToString()
//            null
//        }

    return root
}

// Attaches the LifecycleRegistry to the document
private const val KEY_SAVED_STATE = "saved_state"

private fun LifecycleRegistry.attachToDocument() {
    fun onVisibilityChanged() {
        if (visibilityState(document) == "visible") {
            resume()
        } else {
            stop()
        }
    }

    onVisibilityChanged()

    document.addEventListener(type = "visibilitychange", callback = { onVisibilityChanged() })
}

// Workaround for Document#visibilityState not available in Wasm
@OptIn(ExperimentalWasmJsInterop::class)
@JsFun("(document) => document.visibilityState")
private external fun visibilityState(document: Document): String