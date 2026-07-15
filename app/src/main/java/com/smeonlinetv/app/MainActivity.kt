package com.smeonlinetv.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.smeonlinetv.app.ui.theme.SMEOnlineTVTheme
import com.smeonlinetv.app.ui.screens.SplashScreen
import com.smeonlinetv.app.ui.screens.MainScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMEOnlineTVTheme {
                val showSplash = remember { mutableStateOf(true) }
                
                LaunchedEffect(Unit) {
                    delay(2000)
                    showSplash.value = false
                }
                
                if (showSplash.value) {
                    SplashScreen()
                } else {
                    MainScreen()
                }
            }
        }
    }
}
