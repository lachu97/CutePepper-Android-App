package com.betelguese.cutepepper.presentation.views.ui_elements

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class CustomTheme {
    data class Mypadding(
        val default: Dp = 1.dp,
        val small: Dp = 4.dp,
        val medium: Dp = 8.dp,
        val large: Dp = 10.dp,
        val xtralarge: Dp = 12.dp
    )
    data class CornerRadius(
        val default: Dp = 10.dp,
        val small: Dp = 12.dp,
        val medium: Dp = 16.dp,
        val large: Dp = 24.dp
    )
    data class Mysize(
        val xtrasmall: Dp = 10.dp,
        val verysmall: Dp = 12.dp,
        val small: Dp = 24.dp,
        val medium: Dp = 42.dp,
        val large: Dp = 54.dp,
        val xl: Dp = 96.dp,
        val xxl: Dp = 120.dp,
        val xxxl: Dp = 200.dp,
        val length: Dp = 56.dp,
        val width: Dp = 48.dp,
    )

    data class Elevation(
        val nil:Dp = 1.dp,
        val default: Dp = 4.dp,
        val normal: Dp = 8.dp,
        val high: Dp = 10.dp,
        val very_high: Dp = 12.dp,
    )

    data class Buttoncolors(
        val buttonbg700: Color = Color(0xFFC4C4C4),
        val buttonbgTeal300: Color = Color(0xFF53E0D3),
        val buttonbgTeal500: Color = Color(0xFF1AF1DD)
    )

    data class Mycolors(
        val background: Color = Color.Cyan.copy(
            alpha = 0.7f
        ),
        val topOnText: Color = Color.Black.copy(
            alpha = 0.9f
        ),
        val Teal500: Color = Color(0xFF50EDDE),
        val Teal700: Color = Color(0xFF00FCE4),
        val Border200: Color = Color(0xFF262726),
        val Border500: Color = Color(0xFF070707),
        val Border700: Color = Color(0xFF000000),
        val Text500: Color = Color(0xFF161616),
        val Text700: Color = Color(0xFF000000),
        val Error500: Color = Color(0xFFCC0404),
        val Background500: Color = Color(0xFFD7D7D7),
        val Background700: Color = Color(0xFFE8E8E8),
        val ShimmerBg: Color = Color.LightGray.copy(alpha = 0.9f)
    )
}

val Localpadding = compositionLocalOf { CustomTheme.Mypadding() }
val Localcolor = compositionLocalOf { CustomTheme.Mycolors() }
val Localsize = compositionLocalOf { CustomTheme.Mysize() }
val Localelevation = compositionLocalOf { CustomTheme.Elevation() }
val Localcorneradius = compositionLocalOf { CustomTheme.CornerRadius() }
val MaterialTheme.custompadding: CustomTheme.Mypadding
    @Composable
    @ReadOnlyComposable
    get() = Localpadding.current
val MaterialTheme.customcolor: CustomTheme.Mycolors
    @Composable
    @ReadOnlyComposable
    get() = Localcolor.current
val MaterialTheme.customsize: CustomTheme.Mysize
    @Composable
    @ReadOnlyComposable
    get() = Localsize.current
val MaterialTheme.customelevation: CustomTheme.Elevation
    @Composable
    @ReadOnlyComposable
    get() = Localelevation.current
val MaterialTheme.custom_corneradius: CustomTheme.CornerRadius
    @Composable
    @ReadOnlyComposable
    get() = Localcorneradius.current