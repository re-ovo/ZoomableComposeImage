package me.rerere.zoomableimage

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

/**
 * A image that can be zoomed using gestures
 *
 * @param zoomable Whether to allow zoom
 */
@Composable
fun ZoomableImage(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    zoomable: Boolean = true
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var offsetXState by remember {
        mutableStateOf(0f)
    }
    var offsetYState by remember {
        mutableStateOf(0f)
    }
    var zoomState by remember {
        mutableStateOf(1f)
    }
    val zoomAnimated by animateFloatAsState(targetValue = zoomState)

    fun limitOffset() {
        val srcSize = Size(painter.intrinsicSize.width, painter.intrinsicSize.height)
        val destSize = size.toSize()
        val scaleFactor : ScaleFactor = contentScale.computeScaleFactor(srcSize,destSize)

        val currentWidth = painter.intrinsicSize.width * zoomState * scaleFactor.scaleX
        val currentHeight = painter.intrinsicSize.height * zoomState * scaleFactor.scaleY

        offsetXState = if(currentWidth >= size.width){
            val sizeDiff = (currentWidth - size.width) / 2
            offsetXState.coerceIn(
                (-sizeDiff)..sizeDiff
            )
        } else {
            val sizeDiff = (size.width - currentWidth) / 2
            offsetXState.coerceIn(
                -sizeDiff..sizeDiff
            )
        }

        offsetYState = if(currentHeight >= size.height){
            val sizeDiff = (currentHeight - size.height) / 2
            offsetYState.coerceIn(
                (-sizeDiff)..sizeDiff
            )
        } else {
            val sizeDiff = (size.height - currentHeight) / 2
            offsetYState.coerceIn(
                -sizeDiff..sizeDiff
            )
        }
    }

    Image(
        modifier = modifier
            .clipToBounds()
            .onGloballyPositioned {
                size = it.size
            }
            .graphicsLayer {
                if(zoomable) {
                    this.scaleX = zoomAnimated
                    this.scaleY = zoomAnimated

                    this.translationX = offsetXState
                    this.translationY = offsetYState
                }
            }
            .pointerInput(Unit) {
                // use gesture to adjust zoom/offset
                detectTransformGestures { _, pan, zoom, _ ->
                    zoomState += zoom - 1
                    zoomState = zoomState.coerceAtLeast(1f)

                    offsetXState += pan.x * zoomState
                    offsetYState += pan.y * zoomState

                    limitOffset()
                }
            }
            .pointerInput(Unit) {
                // Double tap to zoom/un-zoom
                detectTapGestures(
                    onDoubleTap = {
                        offsetXState = 0f
                        offsetYState = 0f
                        zoomState = if (zoomState == 1f) {
                            5f
                        } else {
                            1f
                        }
                    }
                )
            },
        painter = painter,
        contentDescription = contentDescription
    )
}