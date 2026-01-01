
package ru.avito.feedpro.ui.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedPrimaryButton(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val radius by animateDpAsState(if (enabled) 30.dp else 20.dp)
    val textColor by animateColorAsState(
        if (enabled) Color.White else Color.White.copy(alpha = 0.4f)
    )

    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xFFFF5722), Color(0xFFFF6600))
                ),
                shape = RoundedCornerShape(radius)
            )
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Text(text = text, color = textColor, style = MaterialTheme.typography.titleMedium)
    }
}
