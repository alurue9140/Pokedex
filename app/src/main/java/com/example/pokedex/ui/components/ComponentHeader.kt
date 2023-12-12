package com.example.pokedex.ui.components

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.pokedex.R

@Composable
fun ComponentHeader(background : Color, img : String) {

    val imageLoader = ImageLoader.Builder(LocalContext.current).components {
        if (SDK_INT >= 28) {
            add(ImageDecoderDecoder.Factory())
        } else {
            add(GifDecoder.Factory())
        }
    }.build()

    Row (
        modifier = Modifier
            .background(
                background,
                RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
            ).height(260.dp).width(393.dp),
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
    {

        AsyncImage(
            model = img,
            placeholder = rememberAsyncImagePainter(R.drawable.loadinfgif, imageLoader),
            error = rememberAsyncImagePainter(R.drawable.loadinfgif, imageLoader),
            contentDescription = "",
            modifier = Modifier.height(190.dp).align(Alignment.Bottom),
            contentScale = ContentScale.Fit
        )






    }
}