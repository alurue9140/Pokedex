package com.example.pokedex.ui.components

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.pokedex.R
import com.example.pokedex.data.models.Pokemon
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageLoaderProvider @Inject constructor(@ActivityContext private val context: Context) {
    val imageLoader: ImageLoader by lazy {
        ImageLoader.Builder(context).components {
            add(GifDecoder.Factory())
            add(ImageDecoderDecoder.Factory())
        }.build()
    }
}

@Composable
fun ComponentHeader(pokemon : Pokemon, imageLoaderProvider: ImageLoaderProvider) {
    Row(
        modifier = Modifier
            .background(
                pokemon.firstType!!.color,
                RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
            ).height(260.dp).width(393.dp),
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = pokemon.imgStr,
            placeholder = rememberAsyncImagePainter(R.drawable.loadinfgif, imageLoaderProvider.imageLoader),
            error = rememberAsyncImagePainter(R.drawable.loadinfgif, imageLoaderProvider.imageLoader),
            contentDescription = "",
            modifier = Modifier.height(190.dp).align(Alignment.Bottom),
            contentScale = ContentScale.Fit
        )
    }
}
