package com.example.pipboyinterface

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.pipboyinterface.ui.theme.PipBoyGreen

// Composable Principal
@Composable
fun PipBoyScreen() {
    var selectedStat by remember { mutableStateOf(specialStats.first()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(8.dp)
    ) {
        TopNavBar()

        HorizontalDivider(color = PipBoyGreen, thickness = 2.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            SpecialStatList(
                stats = specialStats,
                onStatSelected = { stat ->
                    selectedStat = stat
                },
                modifier = Modifier.weight(0.45f)
            )

            StatDetails(
                stat = selectedStat,
                modifier = Modifier.weight(0.55f)
            )
        }

        HorizontalDivider(color = PipBoyGreen, thickness = 2.dp)

        BottomStatusBar()
    }
}

// UI

@Composable
fun TopNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text("STAT", color = PipBoyGreen, fontWeight = FontWeight.Bold)
        Text("INV", color = PipBoyGreen.copy(alpha = 0.5f))
        Text("DATA", color = PipBoyGreen.copy(alpha = 0.5f))
        Text("MAP", color = PipBoyGreen.copy(alpha = 0.5f))
        Text("RADIO", color = PipBoyGreen.copy(alpha = 0.5f))
    }
}

@Composable
fun SpecialStatList(
    stats: List<SpecialStat>,
    onStatSelected: (SpecialStat) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(end = 8.dp)) {
        item {
            Text(
                text = "SPECIAL",
                color = PipBoyGreen,
                fontSize = 28.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        items(stats) { stat ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onStatSelected(stat) }
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(stat.name, color = PipBoyGreen)
                Text(stat.value.toString(), color = PipBoyGreen)
            }
        }
    }
}

@Composable
fun StatDetails(stat: SpecialStat, modifier: Modifier = Modifier) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(start = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(stat.imageRes, imageLoader),
            contentDescription = "${stat.name} animation",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Altura fija para la imagen
                .border(2.dp, PipBoyGreen),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stat.description,
            color = PipBoyGreen,
            fontSize = 18.sp,
            lineHeight = 22.sp
        )
    }
}

@Composable
fun BottomStatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("HP 115/115", color = PipBoyGreen)
        Text("LEVEL 6", color = PipBoyGreen)
        Text("AP 90/90", color = PipBoyGreen)
    }
}

