package com.example.animatednavigator.navigation_animations

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.IntSize

@Stable
fun MainEnterAnimation(): EnterTransition {
    return  expandIn(animationSpec = tween(300), expandFrom = Alignment.Center, initialSize = { IntSize(0, 0) })
}