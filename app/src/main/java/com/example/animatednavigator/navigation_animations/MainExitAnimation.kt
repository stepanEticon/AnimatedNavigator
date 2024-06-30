package com.example.animatednavigator.navigation_animations

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.IntSize

@Stable
fun MainExitAnimation(): ExitTransition {
    return shrinkOut(animationSpec = tween(300), shrinkTowards = Alignment.Center) {
        it
    }
}