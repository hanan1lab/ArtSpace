package trpl.nim234311041.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import trpl.nim234311041.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceScreen()
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    // List of artworks
    val art = listOf(
        Art("Mausoleum Taj Mahal", "India", 1653, R.drawable.image1),
        Art("Machu Picchu", "Peru", 1530, R.drawable.image2),
        Art("Menara Pisa", "Italia", 1372, R.drawable.image3),
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtworkDisplay(art = art[currentIndex])

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                if (currentIndex > 0) currentIndex--
            }) {
                Text("Previous")
            }
            Button(onClick = {
                if (currentIndex < art.size - 1) currentIndex++
            }) {
                Text("Next")
            }
        }
    }
}

@Composable
fun TextWithBackground(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFECEBF4)) // Set the background color
            .padding(16.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ArtworkDisplay(art: Art) {
    // Box to add a frame effect
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(250.dp)
            .padding(4.dp)
            .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp))
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = art.imageResId),
            contentDescription = art.title,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 4f)
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

    TextWithBackground(
        text = art.title,
    )
    TextWithBackground(
        text = "Dari ${art.Nation} (${art.year})",
    )
}