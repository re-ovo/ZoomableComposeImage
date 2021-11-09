package me.rerere.zoomablecomposeimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import me.rerere.zoomablecomposeimage.ui.theme.ZoomableComposeImageTheme
import me.rerere.zoomableimage.ZoomableImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZoomableComposeImageTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Zoomable Compose Image")
                            }
                        )
                    }
                ) {
                    ZoomableImage(
                        modifier = Modifier.size(200.dp).background(Color.Black),
                        painter = rememberImagePainter(
                            data = "https://i0.hdslb.com/bfs/archive/9e5f278027ae7f1e1933b6e4002870361da6c20b.png"
                        )
                    )
                }
            }
        }
    }
}
