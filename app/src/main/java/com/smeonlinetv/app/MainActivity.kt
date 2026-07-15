package com.smeonlinetv.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.smeonlinetv.app.navigation.SMENavigation
import com.smeonlinetv.app.ui.theme.SMEOnlineTVTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMEOnlineTVTheme(
                darkTheme = isSystemInDarkTheme()
            ) {
                SMENavigation()
            }
        }
    }
}
