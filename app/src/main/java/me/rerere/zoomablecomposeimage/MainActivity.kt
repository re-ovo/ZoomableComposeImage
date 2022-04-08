package me.rerere.zoomablecomposeimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    LazyColumn {
                        items(10) {
                            ZoomableImage(
                                modifier = Modifier
                                    .size(200.dp)
                                    .background(Color.Black),
                                painter = rememberImagePainter(
                                    data = "https://www.google.com.hk/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
