package com.ivy.dev.metmuseum.ui.screens.exhibitions

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.ivy.dev.metmuseum.R
import com.ivy.dev.metmuseum.ui.components.TittleBarComponent
import com.ivy.dev.metmuseum.ui.screens.home.HomeAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExhibitionsContent() {
    Scaffold(
        topBar = {
            HomeAppBar(
                onNavigateToSearchPage = {
                }
            )
        }
    ) { it ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            TittleBarComponent(stringResource(id = R.string.exhibition_title))
            Divider()

            VimeoVideo()
           //VideoPlayerComponent(videoUrl = "https://vimeo.com/52099684")
        }
    }
}


@Composable
fun VideoPlayerComponent(videoUrl: String) {
    Column(
        Modifier.size(400.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val mContext = LocalContext.current

        val mExoPlayer = remember(mContext) {
            ExoPlayer.Builder(mContext).build().apply {
                val dataSourceFactory = DefaultDataSourceFactory(
                    mContext,
                    Util.getUserAgent(mContext, mContext.packageName)
                )
                val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(Uri.parse(videoUrl))
                prepare(source)
            }
        }

        // Implementing ExoPlayer
        AndroidView(factory = { context ->
            PlayerView(context).apply {
                player = mExoPlayer
            }
        })
    }

}

@Composable
fun VimeoVideo() {
    AndroidView(factory = { context ->
        PlayerView(context).apply {
            // Create an ExoPlayer instance
            val exoPlayer = ExoPlayer.Builder(context).build()
            player = exoPlayer

            // Set the Vimeo video URL
            val videoUrl = "https://player.vimeo.com/external/52099684.hd.mp4?s=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX&profile_id=119"

            // Create a media item for the video
            val mediaItem = MediaItem.fromUri(videoUrl)

            // Prepare the player with the media item
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.play()
        }
    })
}