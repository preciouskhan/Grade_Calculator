package com.gradeexporter.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val Primary = Color(0xFFDC2626)
private val OnPrimary = Color.White
private val PrimaryContainer = Color(0xFFFEE2E2)
private val OnPrimaryContainer = Color(0xFF7F1D1D)

private val Secondary = Color(0xFF2563EB)
private val OnSecondary = Color.White
private val SecondaryContainer = Color(0xFFDBEAFE)
private val OnSecondaryContainer = Color(0xFF1E40AF)

private val Tertiary = Color(0xFF059669)
private val OnTertiary = Color.White
private val TertiaryContainer = Color(0xFFD1FAE5)
private val OnTertiaryContainer = Color(0xFF065F46)

private val Background = Color(0xFFF8FAFC)
private val OnBackground = Color(0xFF0F172A)
private val Surface = Color.White
private val OnSurface = Color(0xFF0F172A)
private val SurfaceVariant = Color(0xFFF1F5F9)
private val OnSurfaceVariant = Color(0xFF64748B)

private val Error = Color(0xFFDC2626)
private val OnError = Color.White

val Navy = Color(0xFF0F172A)
val NavyLight = Color(0xFF475569)
val MidGray = Color(0xFF64748B)
val Border = Color(0xFFE2E8F0)
val OffWhite = Color(0xFFF8FAFC)
val LightGray = Color(0xFFE2E8F0)
val NavyMid = Color(0xFF1E293B)

object Colors {
    val primary = Primary
    val secondary = Secondary
    val success = Tertiary
    val warning = Color(0xFFF59E0B)
    val navy = Navy
    val navyLight = NavyLight
    val navyMid = NavyMid
    val midGray = MidGray
    val border = Border
    val offWhite = OffWhite
    val lightGray = LightGray
    val background = Background
    val card = Surface
    val white = Color.White
    val blue = Secondary
}

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryContainer,
    onPrimaryContainer = OnPrimaryContainer,
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = SecondaryContainer,
    onSecondaryContainer = OnSecondaryContainer,
    tertiary = Tertiary,
    onTertiary = OnTertiary,
    tertiaryContainer = TertiaryContainer,
    onTertiaryContainer = OnTertiaryContainer,
    error = Error,
    onError = OnError,
    background = Background,
    onBackground = OnBackground,
    surface = Surface,
    onSurface = OnSurface,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurfaceVariant,
    outline = Border
)

@Composable
fun GradeExporterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> darkColorScheme()
        else -> LightColorScheme
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}