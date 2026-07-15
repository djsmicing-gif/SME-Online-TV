package com.smeonlinetv.app.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

object Dimensions {
    val paddingXSmall = 4.dp
    val paddingSmall = 8.dp
    val paddingMedium = 16.dp
    val paddingLarge = 24.dp
    val paddingXLarge = 32.dp
    val paddingXXLarge = 48.dp
    
    val cornerRadiusSmall = 4.dp
    val cornerRadiusMedium = 8.dp
    val cornerRadiusLarge = 16.dp
    val cornerRadiusXLarge = 20.dp
}

@Composable
fun getShapeSmall() = RoundedCornerShape(Dimensions.cornerRadiusSmall)

@Composable
fun getShapeMedium() = RoundedCornerShape(Dimensions.cornerRadiusMedium)

@Composable
fun getShapeLarge() = RoundedCornerShape(Dimensions.cornerRadiusLarge)

@Composable
fun getShapeXLarge() = RoundedCornerShape(Dimensions.cornerRadiusXLarge)
