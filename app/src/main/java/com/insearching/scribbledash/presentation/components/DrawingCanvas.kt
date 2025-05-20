package com.insearching.scribbledash.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.insearching.scribbledash.presentation.DrawingAction
import com.insearching.scribbledash.presentation.PathData
import com.insearching.scribbledash.ui.theme.ScribbleDashTheme
import com.insearching.scribbledash.utils.DevicePreview
import kotlin.math.abs

@Composable
fun DrawingCanvas(
    paths: List<PathData>,
    currentPath: PathData?,
    onAction: (DrawingAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val gridColor = ScribbleDashTheme.colors.onSurfaceVar
    Canvas(
        modifier = modifier
//            .clip(RoundedCornerShape(36.dp))
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(36.dp),
                ambientColor = Color(0x1F726558),
                spotColor = Color(0x1F726558),
            )
            .background(Color.White)
            .pointerInput(true) {
                detectDragGestures(
                    onDragStart = {
                        onAction(DrawingAction.OnNewPathStart)
                    },
                    onDragEnd = {
                        onAction(DrawingAction.OnPathEnd)
                    },
                    onDrag = { change, _ ->
                        onAction(DrawingAction.OnDraw(change.position))
                    },
                    onDragCancel = {
                        onAction(DrawingAction.OnPathEnd)
                    },
                )
            }
    ) {
        val padding = 40f
        // Draw border
        drawRoundRect(
            color = gridColor,
            topLeft = Offset(padding, padding),
            size = Size(size.width - padding * 2, size.height - padding * 2),
            cornerRadius = CornerRadius(36.dp.toPx(), 36.dp.toPx()),
            style = Stroke(width = 1.dp.toPx())
        )

        // Draw grid (3x3)
        val cellWidth = size.width / 3
        val cellHeight = size.height / 3

        // Vertical lines
        for (i in 1..2) {
            drawLine(
                color = gridColor,
                start = Offset(x = i * cellWidth + padding, y = 0f + padding),
                end = Offset(x = i * cellWidth + padding, y = size.height - padding),
                strokeWidth = 1.dp.toPx()
            )
        }
        // Horizontal lines
        for (i in 1..2) {
            drawLine(
                color = gridColor,
                start = Offset(x = 0f + padding, y = i * cellHeight + padding),
                end = Offset(x = size.width - padding, y = i * cellHeight + padding),
                strokeWidth = 1.dp.toPx()
            )
        }

        paths.fastForEach { pathData ->
            drawPath(
                path = pathData.path,
                color = pathData.color,
            )
        }
        currentPath?.let {
            drawPath(
                path = it.path,
                color = it.color
            )
        }
    }
}

private fun DrawScope.drawPath(
    path: List<Offset>,
    color: Color,
    thickness: Float = 10f
) {
    val smoothedPath = Path().apply {
        if (path.isNotEmpty()) {
            moveTo(path.first().x, path.first().y)

            val smoothness = 5
            for (i in 1..path.lastIndex) {
                val from = path[i - 1]
                val to = path[i]
                val dx = abs(from.x - to.x)
                val dy = abs(from.y - to.y)
                if (dx >= smoothness || dy >= smoothness) {
                    quadraticTo(
                        x1 = (from.x + to.x) / 2f,
                        y1 = (from.y + to.y) / 2f,
                        x2 = to.x,
                        y2 = to.y
                    )
                }
            }
        }
    }
    drawPath(
        path = smoothedPath,
        color = color,
        style = Stroke(
            width = thickness,
            cap = StrokeCap.Round,
            join = StrokeJoin.Round
        )
    )
}


@DevicePreview
@Composable
fun DrawingCanvasPreview() {
    ScribbleDashTheme {
        DrawingCanvas(
            paths = emptyList(),
            currentPath = null,
            onAction = {}
        )
    }
}
