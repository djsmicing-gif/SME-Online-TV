package com.smeonlinetv.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smeonlinetv.app.ui.theme.DarkBackground
import com.smeonlinetv.app.ui.theme.DarkBlue
import com.smeonlinetv.app.ui.theme.TextLight

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        DarkBackground,
                        DarkBlue.copy(alpha = 0.1f),
                        DarkBackground
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(
                        color = DarkBlue,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "TV",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextLight
                )
            }
            
            Text(
                text = "SME Online TV",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = TextLight,
                modifier = Modifier.androidx.compose.material3.padding(top = 24.dp)
            )
            
            Text(
                text = "Streaming Excellence",
                fontSize = 14.sp,
                color = com.smeonlinetv.app.ui.theme.TextMedium,
                modifier = Modifier.androidx.compose.material3.padding(top = 8.dp)
            )
        }
    }
}
